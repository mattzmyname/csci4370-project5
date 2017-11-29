package models;


import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase extends Model{

    @Id
    public Integer purchaseId;
    public Integer customerId;
    public Integer flightId;

    public static Finder<Integer,Purchase> find = new Model.Finder<>(Purchase.class);//Finder<PK,class>

}
