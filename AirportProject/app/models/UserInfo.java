package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
@Entity
public class UserInfo extends Model {
 
  private String name;
  @Id
  private String email;
  private String password;
  
  /**
   * Creates a new UserInfo instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */

  public UserInfo(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public static Finder<Integer,UserInfo> find = new Model.Finder<>(UserInfo.class);//Finder<PK,class>
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

}
