package views.Security.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;

/**
 * Backing class for the login form.
 */
public class CreateUserFormData {

  /** The submitted email. */
  public String email = "";
  public String name = "";
  /** The submitted password. */
  public String password = "";

  /** Required for form instantiation. */
  public CreateUserFormData() {
  }

  /**
   * Validates Form<CreateUserFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if (!UserInfoDB.isUser(email)) {
      errors.add(new ValidationError("email", ""));
    }

    return (errors.size() > 0) ? errors : null;
  }

}
