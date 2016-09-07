package javaeightcheatsheet;

import java.util.List;

/**
 * An example of a for each loop.
 * 
 * @author jmateu
 *
 */
public class ForEachPersonExample {
	
	private static List<Person> people = Person.getRandomList();
	
	public static void main(String[] args) {
		javaSeven();
		javaEight();
	}
	
	public static void javaSeven() {
		for (Person person : people) {
			System.out.println(person);
		}
	}
	
	public static void javaEight() {
		people.forEach(person -> System.out.println(person));
	}

}
