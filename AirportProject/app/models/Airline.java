	package models;


import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline extends Model{

    public String airlineName;
    @Id
    public Integer id;
    public Integer airportId;

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
