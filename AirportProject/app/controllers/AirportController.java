package controllers;

import models.Airport;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;
import views.html.airport.*;
import javax.inject.Inject;

public class AirportController extends Controller{

    @Inject
    FormFactory ff;

    public Result index(){
        List<Airport> aps = Airport.find.all();

        return ok(index.render(aps));
    }

    public Result create(){
        Form<Airport> airportForm = ff.form(Airport.class);
        return ok(create.render(airportForm));
    }

    public Result save(){
        Form<Airport> airportForm = ff.form(Airport.class).bindFromRequest();
        Airport ap =  airportForm.get();
        ap.save();
        return redirect(routes.AirportController.index());
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


}
