	package models;


import com.avaje.ebean.Model;
import javax.persistence.*;
import java.util.List;

    @Entity
public class Airline extends Model{

    public String airlineName;
    @Id
    public Integer id;

    @ManyToOne(optional = false,targetEntity= Airport.class)
    @JoinColumn(name="airportId", referencedColumnName="id")
    public Integer airportId;

    @OneToMany(mappedBy = "airlineId", cascade = CascadeType.ALL)
    public List<Gate> GateList;

    @OneToMany(mappedBy = "airlineId", cascade = CascadeType.ALL)
    public List<Flight> FlightList;

    public static Finder<Integer,Airline> find = new Model.Finder<>(Airline.class);//Finder<PK,class>

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public Integer getAirportId() {
        return airportId;
    }
}
