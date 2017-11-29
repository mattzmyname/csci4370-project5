package controllers;

import com.avaje.ebean.Ebean;
import models.Airline;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;
import views.html.airline.*;
import javax.inject.Inject;

public class AirlineController extends Controller{

    @Inject
    FormFactory ff;

    public Result index(){
        List<Airline> aps = Airline.find.all();

        return ok(index.render(aps));
    }

    public Result create(){
        Form<Airline> airlineForm = ff.form(Airline.class);
        return ok(create.render(airlineForm));
    }

    public Result save(){
        DynamicForm af = ff.form().bindFromRequest();
        Form<Airline> airlineForm = ff.form(Airline.class).bindFromRequest();

        System.out.println(af.get("id"));
        System.out.println(af.get("airlineId"));

        Airline al;
        if(airlineForm.hasErrors()){
            return badRequest(create.render(airlineForm));
        }else{
            al =  airlineForm.get();

            al.save();
            return redirect(routes.AirlineController.index());
        }

        //return redirect(routes.AirlineController.index());
    }

    public Result edit(Integer id){
        return TODO;
    }

    public Result update(){
        return TODO;
    }

    public Result destroy(Integer Id){
        return TODO;
    }

    public Result show(Integer id){
        return TODO;
    }

    public Result search()
    {
        Form<Airline> airlineForm = ff.form(Airline.class);
        return ok(search.render(airlineForm));
    }
    public Result results()
    {
        DynamicForm af = ff.form().bindFromRequest();
        String target = af.get("selectField");
        String attr = af.get("Search");

        List<Airline> search = Airline.find.where().eq( target,attr).findList();
        /*Ebean.find(Airline.class)
                .fetch(target)
                .where().eq(target,attr).findList();*/

        return ok(index.render(search));
    }
}
