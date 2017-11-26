package controllers;

import models.Customer;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;
import views.html.customer.*;
import javax.inject.Inject;

public class CustomerController extends Controller{

    @Inject
    FormFactory ff;

    public Result index(){
        List<Customer> cust = Customer.find.all();

        return ok(index.render(cust));
    }

    public Result create(){
        Form<Customer> customerForm = ff.form(Customer.class);
        return ok(create.render(customerForm));
    }

    public Result save(){
        Form<Customer> customerForm = ff.form(Customer.class).bindFromRequest();
        Customer al =  customerForm.get();
        al.save();
        return redirect(routes.CustomerController.index());
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
