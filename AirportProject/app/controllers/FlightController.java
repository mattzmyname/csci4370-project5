package controllers;

import models.Flight;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;

import play.mvc.Security;
import views.html.flight.*;
import javax.inject.Inject;

public class FlightController extends Controller{

    @Inject
    FormFactory ff;

    public Result index(){
        List<Flight> aps = Flight.find.all();

        return ok(index.render(aps));
    }

    public Result create(){
        Form<Flight> flightForm = ff.form(Flight.class);
        return ok(create.render(flightForm));
    }

    public Result save(){
        Form<Flight> form = ff.form(Flight.class).bindFromRequest();

        Flight item;
        if(form.hasErrors()){
            return badRequest(create.render(form));
        }else{
            item = form.get();
            item.save();
            return redirect(routes.FlightController.index());
        }

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
        Form<Flight> flightForm = ff.form(Flight.class);
        return ok(search.render(flightForm));
    }
    @Security.Authenticated(Secured.class)
    public Result results()
    {
        DynamicForm af = ff.form().bindFromRequest();
        String target = af.get("selectField");
        String attr = af.get("Search");

        List<Flight> search = Flight.find.where().eq( target,attr).findList();
        /*Ebean.find(Airline.class)
                .fetch(target)
                .where().eq(target,attr).findList();*/

        return ok(index.render(search));
    }
}
