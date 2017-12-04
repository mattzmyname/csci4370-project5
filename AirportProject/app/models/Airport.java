package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.*;

@Entity
public class Airport extends Model{


    @Id
    public Integer id;
    public String name;
    public String location;

    @OneToMany(mappedBy = "airportId", cascade = CascadeType.ALL)
    public List<Airline> airlineList;

    public static Finder<Integer,Airport> find = new Finder<>(Airport.class);//Finder<PK,class>

    /* Methods using the h2 in-memory database
    //public Airport(){}
    public Airport(Integer id, String name, String location){
        this.id = id;
        this.name = name;
        this.location = location;
    }

    private static Set<Airport> aps;

    static{
        aps = new HashSet<>();
        aps.add(new Airport(50,"Jackson","ATL"));
        aps.add(new Airport(2, "what","somewhere"));
        aps.add(new Airport(30,"Sppon","Korea"));

    }

    public static Set<Airport> all(){
        return aps;
    }

    public static Airport findById(Integer id){
        for(Airport air : aps){
            if(id.equals(air.id)){
                return air;
            }
        }
        return null;
    }

    public static void add(Airport ap){
        aps.add(ap);

    }

    public static boolean remove(Airport ap){
        return aps.remove(ap);
    }
*/
}
