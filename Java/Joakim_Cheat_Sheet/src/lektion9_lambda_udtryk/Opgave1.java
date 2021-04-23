package lektion9_lambda_udtryk;

import java.util.ArrayList;
import java.util.List;

public class Opgave1 {

	/*
	 * opgave 1 fra a til e
	 */
	public void Opgave1() {

		List<Person> list = List.of(new Person("Bent", 25), new Person("Susan", 34), new Person("Mikael", 60),
				new Person("Klaus", 44), new Person("Birgitte", 17), new Person("Liselotte", 9));

		List<Person> persons = new ArrayList<Person>(list);

		persons.forEach(p -> {

			if (p.getAge() == 44) {
				System.out.println(p);
				return;
			}

		});

		persons.forEach(p -> {

			if (p.getName().charAt(0) == 'S')
				System.out.println(p);
		});

		persons.forEach(p -> {

			int iCount = 0;
			for (char c : p.getName().toLowerCase().toCharArray()) {
				if (c == 'i') {
					iCount++;
					if (iCount > 1) {
						System.out.println(p);
						return;
					}
				}
			}
		});

		persons.forEach(p -> {

			if (p.getAge() == p.getName().length()) {
				System.out.println(p);
				return;
			}

		});

		// System.out.println(persons);
		// System.out.println();

	}
}
