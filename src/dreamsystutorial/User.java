package dreamsystutorial;

/**
 * User class for the DreamSys tutorial.
 * 
 * @see <a href="http://www.dreamsyssoft.com/java-8-lambda-tutorial/comparator-tutorial.php">Comparator</a>
 */
public class User {
	  Integer id;
	  String firstName;
	  String lastName;
	  Integer age;

	  User() {}
	  User(int id, String first, String last, int age) {
	    this.id = id;
	    this.firstName = first;
	    this.lastName = last;
	    this.age = age;
	  }

	  public String toString() {
	    return "" + id + ", " + firstName + ", " + lastName + ", " + age;
	  }
	}
