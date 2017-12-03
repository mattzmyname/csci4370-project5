package models;


import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;
@Entity
public class Purchase extends Model{

    @Id
    public Integer purchaseId;
    public Integer customerId;
    public Integer flightId;

    public static Finder<Integer,Purchase> find = new Model.Finder<>(Purchase.class);//Finder<PK,class>

}
