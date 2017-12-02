package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gate extends Model{

    @Id
    public Integer gateId;
    public Integer terminalId;

    @ManyToOne(optional = false,targetEntity= Gate.class)
    @JoinColumn(name="airlineId", referencedColumnName="id")
    public Integer airlineId;

    @ManyToOne(optional = false,targetEntity= Gate.class)
    @JoinColumn(name="airportId", referencedColumnName="airportId")
    public Integer airportId;

    @OneToMany(mappedBy = "gateId", cascade = CascadeType.ALL)
    public List<Flight> FlightList;


    public static Finder<Integer,Gate> find = new Model.Finder<>(Gate.class);//Finder<PK,class>

}
