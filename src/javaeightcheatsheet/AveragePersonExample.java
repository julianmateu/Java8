package javaeightcheatsheet;

import java.util.List;

/**
 * An example that maps a list of people to a list of ages and reduces it to the average.
 * 
 * @author jmateu
 *
 */
public class AveragePersonExample {
	private static List<Person> people = Person.getSamplesList();
	
	public static void main(String[] args) {
		System.out.println("Java seven:");
		javaSeven();
		System.out.println("\nJava eight:");
		javaEight();
	}
	
	public static void javaSeven() {
		double average = 0;
		for (Person person : people) {
			average += person.getAge();
		}
		average /= people.size();
		System.out.println("\t" + average);
	}
	
	public static void javaEight() {
		double average = people.stream()
				.mapToInt(person -> person.getAge())
				.average().getAsDouble();
		System.out.println("\t" + average);
	}
}
