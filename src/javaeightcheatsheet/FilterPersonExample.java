package javaeightcheatsheet;

import java.util.List;

/**
 * An example that filters a list of people to get the ones that meet ceratin condition.
 * 
 * @author jmateu
 *
 */
public class FilterPersonExample {
	private static List<Person> people = Person.getSamplesList();
	
	public static void main(String[] args) {
		System.out.println("Java seven:");
		javaSeven();
		System.out.println("\nJava eight:");
		javaEight();
	}
	
	public static void javaSeven() {
		for (Person person : people) {
			if (person.getName().startsWith("S")) {
				System.out.println("\t" + person);
			}
		}
	}
	
	public static void javaEight() {
		people.stream().filter(person -> person.getName().startsWith("S")).forEach(person -> System.out.println("\t" + person));
	}
}
