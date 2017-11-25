package models;

import com.avaje.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gate {

    @Id
    public Integer gateId;
    public Integer terminalId;
    public Integer airlineId;
    public Integer airportId;

    public static Model.Finder<Integer,Gate> find = new Model.Finder<>(Gate.class);//Finder<PK,class>

}
