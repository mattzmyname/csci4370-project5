package models;


import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline extends Model{

    public String airlineName;
    public Integer id;
    @Id
    public Integer airportId;

    public static Finder<Integer,Airline> find = new Model.Finder<>(Airline.class);//Finder<PK,class>

}
