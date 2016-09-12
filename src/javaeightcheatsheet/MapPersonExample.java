package javaeightcheatsheet;

import java.util.List;
import java.util.stream.Collectors;

/**
 * An example that maps a list of people to a list of last names.
 * 
 * @author jmateu
 *
 */
public class MapPersonExample {
	private static List<Person> people = Person.getRandomList();
	
	public static void main(String[] args) {
		System.out.println("Java seven:");
		javaSeven();
		System.out.println("\nJava eight:");
		javaEight();
	}
	
	public static void javaSeven() {
		for (Person person : people) {
			System.out.println("\t" + person.getLastName());
		}
	}
	
	public static void javaEight() {
		people.stream().map(person -> person.getLastName()).collect(Collectors.toList()).
			forEach(string -> System.out.println("\t" + string));
	}
}
