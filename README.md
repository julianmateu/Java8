# Java 8 cheatsheet

## Person class

```java
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
	
	public static List<Person> getSamplesList() {
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
```

Before each of the following examples, the following definition is made:

```java
List<Person> people = Person.getSamplesList();
```

### For each loop
<table>
<thead>
<tr>
  <th>Java 7</th>
  <th>Java 8</th>
</tr>
</thead>
<tbody>
<tr>
  <td>
  <pre>for (Person person : people) {
  System.out.println(person);
}  
  </pre>
  </td>
  <td><pre>people
  .forEach(person -> System.out.println(person));</pre></td>
</tr>

</tbody>
</table>

### Filter
<table>
<thead>
<tr>
  <th>Java 7</th>
  <th>Java 8</th>
</tr>
</thead>
<tbody>
<tr>
  <td>
  <pre>for (Person person : people) {
  if (person.getName().startsWith("S")) {
  	System.out.println(person);
  }
}  
  </pre>
  </td>
  <td><pre>people.stream()
  .filter(person -> person.getName().startsWith("S"))
  .forEach(person -> System.out.println(person));</pre></td>
</tr>

</tbody>
</table>

### Sorting
<table>
<thead>
<tr>
  <th>Java 7</th>
  <th>Java 8</th>
</tr>
</thead>
<tbody>
<tr>
  <td>
  <pre>Collections.sort(people, new Comparator<Person>() { 
  @Override
  public int compare(Person p1, Person p2) {
  	return p1.getAge().compareTo(p2.getAge());
  }
});</pre>
  </td>
  <td><pre>Collections.sort(
  people,
  (Person p1, Person p2) 
  	-> p1.getAge().compareTo(p2.getAge())
);
</pre></td>
</tr>

</tbody>
</table>

### Map
<table>
<thead>
<tr>
  <th>Java 7</th>
  <th>Java 8</th>
</tr>
</thead>
<tbody>
<tr>
  <td>
  <pre>List<Person> lastNames
for (Person person : people) {
	lastNames.add(person.getAge());
}
  </pre>
  </td>
  <td><pre>people.stream()
  .map(person -> person.getLastName())
  .collect(Collectors.toList());</pre></td>
</tr>

</tbody>
</table>

### Reduce
#### Average:
<table>
<thead>
<tr>
  <th>Java 7</th>
  <th>Java 8</th>
</tr>
</thead>
<tbody>
<tr>
  <td>
  <pre>double average = 0;
for (Person person : people) {
	average += person.getAge();
}
average /= people.size();</pre>
  </td>
  <td><pre>double average = people.parallelStream()
  .mapToInt(person -> person.getAge())
  .average().getAsDouble();</pre></td>
</tr>

</tbody>
</table>

#### Count the number of people whose age is an even number:

We use the following auxiliary method:

```java
/**
 * Returns 1 if the number is even and 0 if it is odd.
 * 
 * @param number
 * @return int		1 if number is even, 0 if it is odd.
 */
private static int oneIfEven(int number) {
	return (number % 2) == 0 ? 1 : 0;
}
```

<table>
<thead>
<tr>
  <th>Java 7</th>
  <th>Java 8</th>
</tr>
</thead>
<tbody>
<tr>
  <td>
  <pre>int evenCount = 0;
for (Person person : people) {
	evenCount += oneIfEven(person.getAge());
}
  </pre>
  </td>
  <td><pre>int evenCount = people.stream()
  .mapToInt(person -> person.getAge())
  .reduce(
  	0,
  	(int partialCount, int age)
  		-> partialCount + oneIfEven(age)
  );</pre></td>
</tr>

</tbody>
</table>
