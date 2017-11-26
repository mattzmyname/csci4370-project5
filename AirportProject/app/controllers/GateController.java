package controllers;

import models.Gate;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;
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
        Form<Gate> gateForm = ff.form(Gate.class).bindFromRequest();
        Gate ap =  gateForm.get();
        ap.save();
        return redirect(routes.GateController.index());
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
