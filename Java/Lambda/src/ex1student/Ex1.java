package ex1student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

	public static void main(String[] args) {
		List<Person> list = List.of(new Person("Bent", 25), new Person("Susan", 34), new Person("Mikael", 60),
				new Person("Klaus", 44), new Person("Birgitte", 17), new Person("Liselotte", 9));
		List<Person> persons = new ArrayList<Person>(list);
		persons.forEach(p -> {
			if (p.getAge() == 44) {
				System.out.println(p.getName());
			}
		});
		System.out.println();
		persons.forEach(p -> {
			if (p.getName().charAt(0) == 'S')
				System.out.println(p.getName());
		});
		
		persons.stream()
			.filter(p -> p.getName().startsWith("S"))
			.forEach(p -> System.out.println(p.getName()));
		
		System.out.println();
		persons.forEach(p -> {
			
		});
	}

	/**
	 * Returns from the list the first person that satisfies the predicate. Returns
	 * null, if no person satisfies the predicate.
	 */
	public static Person findFirst(List<Person> list, Predicate<Person> filter) {
		for (Person p : list) {
			if (filter.test(p))
				return p;
		}
		return null;
	}
}
