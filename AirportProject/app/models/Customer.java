 package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer extends Model{

    public String fName;
    public String lName;
    public String cCity;
    public Integer flightNo;
    @Id
    public Integer cId;

    public static Finder<Integer,Customer> find = new Model.Finder<>(Customer.class);//Finder<PK,class>

}
