package controllers;

import models.Airline;
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
        Form<Airline> airlineForm = ff.form(Airline.class).bindFromRequest();
        Airline al =  airlineForm.get();
        al.save();
        return redirect(routes.AirlineController.index());
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
        return ok(search.render());
    }
    public Result results(String target,String attribute, String database)
    {
       return resultspage(target,attribute,database);
    }
    public Result resultspage (String target,String attribute, String database){
        return ok(result.render(target,attribute,database));
    }

}
