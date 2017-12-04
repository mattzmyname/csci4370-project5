package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.List;
@Entity
public class Gate extends Model{

    @Id
    public Integer gateId;
    public Integer terminalId;

    @ManyToOne(optional = false,targetEntity= Airline.class)
    @JoinColumn(name="airlineId", referencedColumnName="id")
    public Integer airlineId;

    public Integer airportId;



    public static Finder<Integer,Gate> find = new Model.Finder<>(Gate.class);//Finder<PK,class>

}
