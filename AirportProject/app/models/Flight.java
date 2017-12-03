package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.*;
import java.util.List;
@Entity
public class Flight extends Model{

    @Id
    public Integer id;
    public Integer airlineId;
    public Date departureTime;
    public Date arrivalTime;
    public String departureCity;
    public String arrivalCity;
    public Integer gateId;



    public static Finder<Integer,Flight> find = new Model.Finder<>(Flight.class);//Finder<PK,class>

}
