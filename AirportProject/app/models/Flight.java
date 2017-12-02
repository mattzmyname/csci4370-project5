package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Flight extends Model{

    @Id
    public Integer id;

    @ManyToOne(optional = false,targetEntity= Flight.class)
    @JoinColumn(name="airlineId", referencedColumnName="id")
    public Integer airlineId;

    public Date departureTime;
    public Date arrivalTime;
    public String departureCity;
    public String arrivalCity;

    @ManyToOne(optional = false,targetEntity= Flight.class)
    @JoinColumn(name="gateId", referencedColumnName="gateId")
    public Integer gateId;

    @ManyToMany(mappedBy = "flightNo", cascade = CascadeType.ALL)
    public List<Customer> CustomerList;

    @ManyToMany(mappedBy = "flightId", cascade = CascadeType.ALL)
    public List<Purchase> PurchaseList;


    public static Finder<Integer,Flight> find = new Model.Finder<>(Flight.class);//Finder<PK,class>

}
