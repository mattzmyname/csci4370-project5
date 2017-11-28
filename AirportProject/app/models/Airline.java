package models;


import com.avaje.ebean.Model;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
public class Airline extends Model{

    public String airlineName;
    @Id
    public Integer id;
    @OneToMany(mappedBy = "Airline", cascade=CascadeType.ALL)
    public Integer airportId;

    public static Finder<Integer,Airline> find = new Model.Finder<>(Airline.class);//Finder<PK,class>

}
