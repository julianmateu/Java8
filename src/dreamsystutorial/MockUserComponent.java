package dreamsystutorial;

import java.util.*;
import java.util.stream.*;

/**
 * Mock user component class for the DreamSys tutorial.
 * 
 * @see <a href="http://www.dreamsyssoft.com/java-8-lambda-tutorial/dry-tutorial.php">DRY</a>
 */
public class MockUserComponent implements UserComponent {
  List<User> users = new ArrayList<User>();

  public UserResponse fetchAllUsers(UserRequest req) {
    return new UserResponse(users);
  }

  public UserResponse fetchUser(UserRequest req) {
    return new UserResponse(users.stream().filter(u -> u.id.equals(req.user.id)).collect(Collectors.toList()));
  }

  public UserResponse deleteUser(UserRequest req) {
    users = users.stream().filter(u -> (!u.id.equals(req.user.id))).collect(Collectors.toList());
    return new UserResponse();
  }

  public UserResponse updateUser(UserRequest req) {
    User user = users.stream().filter(u -> u.id.equals(req.user.id)).collect(Collectors.toList()).get(0);
    user.firstName = req.user.firstName;
    user.lastName = req.user.lastName;
    user.age = req.user.age;
    return new UserResponse();
  }

  public UserResponse insertUser(UserRequest req) {
    users.add(req.user);
    return new UserResponse();
  }
}
