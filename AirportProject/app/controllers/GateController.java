package controllers;

import models.Gate;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;

import play.mvc.Security;
import views.html.gate.*;
import javax.inject.Inject;

public class GateController extends Controller{

    @Inject
    FormFactory ff;

    public Result index(){
        List<Gate> aps = Gate.find.all();

        return ok(index.render(aps));
    }

    public Result create(){
        Form<Gate> gateForm = ff.form(Gate.class);
        return ok(create.render(gateForm));
    }

    public Result save(){
        Form<Gate> form = ff.form(Gate.class).bindFromRequest();

        Gate item;
        if(form.hasErrors()){
            return badRequest(create.render(form));
        }else{
            item = form.get();
            item.save();
            return redirect(routes.GateController.index());
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
        Form<Gate> airlineForm = ff.form(Gate.class);
        return ok(search.render(airlineForm));
    }
    @Security.Authenticated(Secured.class)
    public Result results()
    {
        DynamicForm af = ff.form().bindFromRequest();
        String target = af.get("selectField");
        String attr = af.get("Search");

        List<Gate> search = Gate.find.where().eq( target,attr).findList();
        /*Ebean.find(Airline.class)
                .fetch(target)
                .where().eq(target,attr).findList();*/

        return ok(index.render(search));
    }
}
