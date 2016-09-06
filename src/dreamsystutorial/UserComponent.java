package dreamsystutorial;

/**
 * User component interface for the DreamSys tutorial.
 * 
 * @see <a href="http://www.dreamsyssoft.com/java-8-lambda-tutorial/dry-tutorial.php">DRY</a>
 */
public interface UserComponent {
	  UserResponse fetchAllUsers(UserRequest req);
	  UserResponse fetchUser(UserRequest req);
	  UserResponse deleteUser(UserRequest req);
	  UserResponse updateUser(UserRequest req);
	  UserResponse insertUser(UserRequest req);
	}
