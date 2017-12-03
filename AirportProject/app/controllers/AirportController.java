package controllers;

import models.Airport;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;

import play.mvc.Security;
import views.html.airport.*;
import javax.inject.Inject;

public class AirportController extends Controller{

    @Inject
    FormFactory ff;

    @Security.Authenticated(Secured.class)
    public Result index(){
        List<Airport> aps = Airport.find.all();

        return ok(index.render("All Airports", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),aps));
    }
    @Security.Authenticated(Secured.class)
    public Result create(){
        Form<Airport> airportForm = ff.form(Airport.class);
        return ok(create.render("Create Airports", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),airportForm));
    }
    @Security.Authenticated(Secured.class)
    public Result save(){
        Form<Airport> form = ff.form(Airport.class).bindFromRequest();

        Airport al;
        if(form.hasErrors()){
            return badRequest(create.render("Create Airports", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),form));
        }else{
            al = form.get();
            al.save();
            return redirect(routes.AirportController.index());
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
    @Security.Authenticated(Secured.class)
    public Result search()
    {
        Form<Airport> apForm = ff.form(Airport.class);
        return ok(search.render("Search Airports", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),apForm));
    }
    @Security.Authenticated(Secured.class)
    public Result results()
    {
        DynamicForm af = ff.form().bindFromRequest();
        String target = af.get("selectField");
        String attr = af.get("Search");

        List<Airport> search = Airport.find.where().eq( target,attr).findList();
        /*Ebean.find(Airline.class)
                .fetch(target)
                .where().eq(target,attr).findList();*/

        return ok(index.render("All Airports", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),search));
    }
}
