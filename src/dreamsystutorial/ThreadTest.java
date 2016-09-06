package dreamsystutorial;

/**
 * Thread test class for the Introduction of the DreamSys tutorial.
 * 
 * @see <a href="http://www.dreamsyssoft.com/java-8-lambda-tutorial/intro-tutorial.php">Introduction</a>
 */
public class ThreadTest {
	  public static void main(String[] args) {
	    Runnable r1 = new Runnable() {
	      @Override
	      public void run() {
	        System.out.println("Old Java Way");
	      }
	    };

	    Runnable r2 = () -> { System.out.println("New Java Way"); };

	    new Thread(r1).start();
	    new Thread(r2).start();
	    new Thread(() -> System.out.println("New Java Way Short")).start();
	  }
	}
