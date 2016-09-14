package javaeightcheatsheet;

import java.util.List;

/**
 * An example that maps a list of people to a list of ages and reduces it to the number of even ages.
 * 
 * @author jmateu
 *
 */
public class ReducePersonExample {
	private static List<Person> people = Person.getSamplesList();
	
	public static void main(String[] args) {
		System.out.println("Java seven:");
		javaSeven();
		System.out.println("\nJava eight:");
		javaEight();
	}
	
	public static void javaSeven() {
		int evenCount = 0;
		for (Person person : people) {
			evenCount += oneIfEven(person.getAge());
		}
		System.out.println("\t" + evenCount);
	}
	
	public static void javaEight() {
		int evenCount = people.stream()
				.mapToInt(person -> person.getAge())
				.reduce(0, (int partialCount, int age) -> partialCount + oneIfEven(age));
		System.out.println("\t" + evenCount);
	}
	
	/**
	 * Returns 1 if the number is even and 0 if it is odd.
	 * 
	 * @param number
	 * @return int		1 if number is even, 0 if it is odd.
	 */
	private static int oneIfEven(int number) {
		return (number % 2) == 0 ? 1 : 0;
	}
}
