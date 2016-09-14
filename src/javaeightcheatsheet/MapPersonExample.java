package javaeightcheatsheet;

import java.util.ArrayList;
import java.util.List;

/**
 * An example that maps a list of people to a list of last names.
 * 
 * @author jmateu
 *
 */
public class MapPersonExample {
	private static List<Person> people = Person.getSamplesList();
	
	public static void main(String[] args) {
		System.out.println("Java seven:");
		javaSeven();
		System.out.println("\nJava eight:");
		javaEight();
	}
	
	public static void javaSeven() {
		List<String> lastNames = new ArrayList<>();
		for (Person person : people) {
			lastNames.add(person.getLastName());
			System.out.println("\t" + person.getLastName());
		}
		
	}
	
	public static void javaEight() {
		people.stream()
		.map(person -> person.getLastName())
		.forEach(string -> System.out.println("\t" + string));
	}
}
