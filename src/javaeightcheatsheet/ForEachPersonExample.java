package javaeightcheatsheet;

public class ForEachPersonExample {
	
	public static void main(String[] args) {
		javaSeven();
		javaEight();
	}
	
	public static void javaSeven() {
		for (Person person : Person.getRandomList()) {
			System.out.println(person);
		}
	}
	
	public static void javaEight() {
		Person.getRandomList().forEach(person -> System.out.println(person));
	}

}
