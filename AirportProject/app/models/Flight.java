package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Flight {

    @Id
    public Integer id;
    public Integer airlineId;
    public Date departureTime;
    public Date arrivalTime;
    public String departureCity;
    public String arrivalCity;
    public Integer gateId;

    public static Model.Finder<Integer,Flight> find = new Model.Finder<>(Flight.class);//Finder<PK,class>

}
