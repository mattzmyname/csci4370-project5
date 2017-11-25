package models;


import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {

    public String airlineName;
    public Integer id;
    @Id
    public Integer airportId;

    public static Model.Finder<Integer,Airline> find = new Model.Finder<>(Airline.class);//Finder<PK,class>

}
