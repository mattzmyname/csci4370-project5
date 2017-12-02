 package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer extends Model{

    public String fName;
    public String lName;
    public String cCity;

    @ManyToMany(optional = false,targetEntity= Customer.class)
    @JoinColumn(name="flightNo", referencedColumnName="id")
    public Integer flightNo;
    @Id
    public Integer cId;

    @ManyToOne(mappedBy = "customerId", cascade = CascadeType.ALL)
    public List<Purchase> PurchaseList;

    public static Finder<Integer,Customer> find = new Model.Finder<>(Customer.class);//Finder<PK,class>

}
