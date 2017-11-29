package controllers;

import models.Purchase;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;
import views.html.purchase.*;
import javax.inject.Inject;

public class PurchaseController extends Controller{

    @Inject
    FormFactory ff;

    public Result index(){
        List<Purchase> ps = Purchase.find.all();

        return ok(index.render(ps));
    }

    public Result create(){
        Form<Purchase> purchaseForm = ff.form(Purchase.class);
        return ok(create.render(purchaseForm));
    }

    public Result save(){
        Form<Purchase> form = ff.form(Purchase.class).bindFromRequest();

        Purchase item;
        if(form.hasErrors()){
            return badRequest(create.render(form));
        }else{
            item = form.get();
            item.save();
            return redirect(routes.PurchaseController.index());
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


}