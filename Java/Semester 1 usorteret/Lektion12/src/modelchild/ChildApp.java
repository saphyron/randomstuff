package modelchild;

import java.util.Arrays;

public class ChildApp {

	public static void main(String[] args) {
		Institution i1 = new Institution("John", "vej20");
		Child c1 = new Child(4, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old
		Child c3 = new Child(5, true);// boy 5 years old
		Child c4 = new Child(3, false);// girl 3 years old
		System.out.println("Den største vægtøgelse på et år er: " + c1.getIncrease());
		System.out.println("Et barn på " + c1.getAge() + " vejer " + c1.getWeight(3) + " kg.");
		System.out.println("- - - - - - - - - - - - - - - ");
		
		i1.addChild(c1);
		i1.addChild(c2);
		i1.addChild(c3);
		i1.addChild(c4);
		System.out.println(i1.averageAge());
		System.out.println(i1.numberOfBoys());
		System.out.println(i1.numberOfGirls());
	}

}
