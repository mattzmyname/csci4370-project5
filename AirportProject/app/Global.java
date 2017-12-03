import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;

/**
 * Provide initialization code for the digits application.
 * @author Philip Johnson
 */
public class Global extends GlobalSettings {

  /**
   * Initialize the system with some sample contacts.
   * @param app The application.
   */
  public void onStart(Application app) {
<<<<<<< HEAD
    UserInfoDB.addUserInfo("smith@example.com","John Smith", "password");
=======
    UserInfoDB.addUserInfo( "smith@example.com","John Smith", "password");
>>>>>>> 34be8d74179157303c92e7ee113aafa713fe80d1
  }
}
