package dreamsystutorial;

import java.util.List;

/**
 * User response class for the DreamSys tutorial.
 * 
 * @see <a href="http://www.dreamsyssoft.com/java-8-lambda-tutorial/dry-tutorial.php">DRY</a>
 */
public class UserResponse {
  List<User> users;
  boolean success = true;

  public UserResponse() {

  }

  public UserResponse(List<User> users) {
    this.users = users;
  }
}
