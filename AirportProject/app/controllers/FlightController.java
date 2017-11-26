package controllers;

import models.Flight;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;
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
        Form<Flight> flightForm = ff.form(Flight.class).bindFromRequest();
        Flight ap =  flightForm.get();
        ap.save();
        return redirect(routes.FlightController.index());
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
