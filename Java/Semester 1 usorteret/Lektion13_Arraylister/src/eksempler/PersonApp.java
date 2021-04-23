package eksempler;

import java.util.ArrayList;

public class PersonApp {

	public static void main(String[] args) {
		
		ArrayList<Person> personer = new ArrayList<Person>();
		
		Person p1 = new Person("Ulla", 22);
		Person p2 = new Person("Fin", 48);
		Person p3 = new Person("Ib", 12);
		Person p4 = new Person("Bo", 80);
		
		personer.add(p1);
		personer.add(p2);
		personer.add(p3);
		personer.add(p4);
		
		double sum = 0;
		for (Person p : personer) {
			sum = sum + p.getAlder();
		}
		System.out.println("Gennemsnidtet er: " + sum/personer.size());

	}

}
