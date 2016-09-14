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
  <pre>for (Person person : people) { <br> &nbsp;System.out.println(person);<br>}  
  </pre>
  </td>
  <td><pre>people<br>&nbsp;.forEach(person -> System.out.println(person));</pre></td>
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
  <pre>for (Person person : people) {<br> &nbsp; if (person.getName().startsWith("S")) {<br> &nbsp; &nbsp;System.out.println(person);<br> &nbsp; }<br>}  
  </pre>
  </td>
  <td><pre>people.stream()<br>&nbsp;.filter(person -> person.getName().startsWith("S"))<br>&nbsp;.collect(Collectors.toList())<br>&nbsp;.forEach(person -> System.out.println(person));</pre></td>
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
  <pre>List<Person> unsortedPeople = new ArrayList<>(people);<br>&nbsp;&nbsp;Collections.sort(unsortedPeople, new Comparator<Person>() {<br>&nbsp;&nbsp;&nbsp;&nbsp;@Override<br>&nbsp;&nbsp;&nbsp;&nbsp;public int compare(Person p1, Person p2) {<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;return p1.getAge().compareTo(p2.getAge());<br>&nbsp;&nbsp;&nbsp;&nbsp;}<br>&nbsp;&nbsp;});
for (Person person : unsortedPeople) {
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(person);
} 
  </pre>
  </td>
  <td><pre>List<Person> unsortedPeople = new ArrayList<>(people);
Collections.sort(<br>&nbsp;unsortedPeople,<br>&nbsp;(Person p1, Person p2)<br>&nbsp;&nbsp;-> p1.getAge().compareTo(p2.getAge()));
unsortedPeople<br>&nbsp;.forEach(person -> System.out.println(person));</pre></td>
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
  <pre>for (Person person : people) {<br>&nbsp;&nbsp;System.out.println(person.getLastName());
}
  </pre>
  </td>
  <td><pre>people.stream()<br>&nbsp;.map(person -> person.getLastName())<br>&nbsp;.collect(Collectors.toList())<br>&nbsp;.forEach(string -> System.out.println(string));</pre></td>
</tr>

</tbody>
</table>

### Map-reduce
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
&nbsp;&nbsp;average += person.getAge();
}
average /= people.size();
System.out.println(average);
  </pre>
  </td>
  <td><pre>double average = people.parallelStream().<br>&nbsp;mapToInt(person -> person.getAge()).average().getAsDouble();
System.out.println(average);</pre></td>
</tr>

</tbody>
</table>

#### Count the number of people whose age is an even number:
```java
/**
 * Returns 1 if the number is even and 0 if it is odd.
 * 
 * @param number
 * @return int		1 if number is even, 0 if it is odd.
 */
private static int oneIfEven(int number) {
	return (number + 1) % 2;
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
&nbsp;&nbsp;evenCount += oneIfEven(person.getAge());
}
System.out.println(evenCount);
  </pre>
  </td>
  <td><pre>// Can not use parallel stream here
int evenCount = people.stream()<br>&nbsp;.mapToInt(person -> person.getAge())<br>&nbsp;.reduce(0, (int partialCount, int age) -> partialCount + oneIfEven(age));
System.out.println(venCount);</pre></td>
</tr>

</tbody>
</table>
