package controllers;

import com.avaje.ebean.Ebean;
import models.Airline;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import java.util.List;
import java.util.Set;
import views.html.airline.*;
import javax.inject.Inject;

public class AirlineController extends Controller{

    @Inject
    FormFactory ff;

  /**
   * Provides the Profile page (only to authenticated users).
   * @return The Profile page. 
   */
   @Security.Authenticated(Secured.class)
    public Result index(){
        List<Airline> aps = Airline.find.all();

        return ok(index.render("All Airlines", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),aps));
    }

    @Security.Authenticated(Secured.class)
    public Result create(){
        Form<Airline> airlineForm = ff.form(Airline.class);
        return ok(create.render("Create Airlines", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),airlineForm));
    }

    @Security.Authenticated(Secured.class)
    public Result save(){
        Form<Airline> airlineForm = ff.form(Airline.class).bindFromRequest();

        Airline al;
        if(airlineForm.hasErrors()){
            return badRequest(create.render("All Airlines", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),airlineForm));
        }else{
            al =  airlineForm.get();
            al.save();
            return redirect(routes.AirlineController.index());
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
        Form<Airline> airlineForm = ff.form(Airline.class);
        return ok(search.render(airlineForm));
    }
    @Security.Authenticated(Secured.class)
    public Result results()
    {
        DynamicForm af = ff.form().bindFromRequest();
        String target = af.get("selectField");
        String attr = af.get("Search");

        List<Airline> search = Airline.find.where().eq( target,attr).findList();
        /*Ebean.find(Airline.class)
                .fetch(target)
                .where().eq(target,attr).findList();*/

        return ok(index.render("Search Results", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),search));
    }
}
