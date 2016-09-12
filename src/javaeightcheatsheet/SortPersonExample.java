package javaeightcheatsheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * An example that sorts a list of people.
 * 
 * @author jmateu
 *
 */
public class SortPersonExample {
	private static List<Person> people = Person.getRandomList();
	
	public static void main(String[] args) {
		System.out.println("Java seven:");
		javaSeven();
		System.out.println("\nJava eight:");
		javaEight();
	}
	
	public static void javaSeven() {
		List<Person> unsortedPeople = new ArrayList<>(people);
		Collections.sort(unsortedPeople, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge().compareTo(p2.getAge());
			}
		});
		for (Person person : unsortedPeople) {
			System.out.println("\t" + person);
		}
	}
	
	public static void javaEight() {
		List<Person> unsortedPeople = new ArrayList<>(people);
		Collections.sort(unsortedPeople, (Person p1, Person p2) -> p1.getAge().compareTo(p2.getAge()));
		unsortedPeople.forEach(person -> System.out.println("\t" + person));
	}
}
