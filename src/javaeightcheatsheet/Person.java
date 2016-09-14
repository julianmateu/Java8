package javaeightcheatsheet;

import java.util.Arrays;
import java.util.List;

public class Person {
	
	private String mName;
	private String mLastName;
	private Integer mAge;
	
	public Person(String name, String lastName, Integer age) {
		mName = name;
		mLastName = lastName;
		mAge = age;
	}

	public String getName() {
		return mName;
	}

	public String getLastName() {
		return mLastName;
	}

	public Integer getAge() {
		return mAge;
	}
	
	@Override
	public String toString() {
		return mName + " " + mLastName + ", " + mAge;
	}
	
	public static List<Person> getRandomList() {
		  return Arrays.asList(
			      new Person("Steve", "Vai", 40),
			      new Person("Joe", "Smith", 32),
			      new Person("Steve", "Johnson", 57),
			      new Person("Mike", "Stevens", 18),
			      new Person("George", "Armstrong", 24),
			      new Person("Jim", "Smith", 40),
			      new Person("Chuck", "Schneider", 34),
			      new Person("Jorje", "Gonzales", 22),
			      new Person("Jane", "Michaels", 47),
			      new Person("Kim", "Berlie", 60)
			    );
	}
}
