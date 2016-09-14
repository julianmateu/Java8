package javaeightcheatsheet;

import java.util.List;

/**
 * An example of a for each loop.
 * 
 * @author jmateu
 *
 */
public class ForEachPersonExample {
	private static List<Person> people = Person.getSamplesList();
	
	public static void main(String[] args) {
		System.out.println("Java seven:");
		javaSeven();
		System.out.println("\nJava eight:");
		javaEight();
	}
	
	public static void javaSeven() {
		for (Person person : people) {
			System.out.println("\t" + person);
		}
	}
	
	public static void javaEight() {
		people.forEach(person -> System.out.println("\t" + person));
	}
}
