package controllers;

import models.Customer;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;

import play.mvc.Security;
import views.html.customer.*;
import javax.inject.Inject;

public class CustomerController extends Controller{

    @Inject
    FormFactory ff;
    @Security.Authenticated(Secured.class)
    public Result index(){
        List<Customer> cust = Customer.find.all();

        return ok(index.render("All Customers", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),cust));
    }
    @Security.Authenticated(Secured.class)
    public Result create(){
        Form<Customer> customerForm = ff.form(Customer.class);
        return ok(create.render("All Customers", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),customerForm));
    }
    @Security.Authenticated(Secured.class)
    public Result save(){
        Form<Customer> form = ff.form(Customer.class).bindFromRequest();

        Customer item;
        if(form.hasErrors()){
            return badRequest(create.render("All Customers", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),form));
        }else{
            item = form.get();
            item.save();
            return redirect(routes.CustomerController.index());
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
        Form<Customer> customerForm = ff.form(Customer.class);
        return ok(search.render("All Customers", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),customerForm));
    }
    @Security.Authenticated(Secured.class)
    public Result results()
    {
        DynamicForm af = ff.form().bindFromRequest();
        String target = af.get("selectField");
        String attr = af.get("Search");

        List<Customer> search = Customer.find.where().eq( target,attr).findList();
        /*Ebean.find(Airline.class)
                .fetch(target)
                .where().eq(target,attr).findList();*/

        return ok(index.render("All Customers", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),search));
    }
}
