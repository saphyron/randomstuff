package opgaver;

public class MainApp {

	public static void main(String[] args) {
		ArrayStack a1 = new ArrayStack();

		int i1 = 10;
		int i2 = 5;
		int i3 = 2;
		int i4 = 1;
		int i5 = 3;
		int i6 = 15;

		System.out.println("Array is Empthy: " + a1.isEmpty());
		a1.push(i1);
		System.out.println("Size is: " + a1.size());
		System.out.println("Array is Empthy: " + a1.isEmpty());
		System.out.println("Current stacks values is: " + a1.peek());
		System.out.println();
		a1.push(i2);
		System.out.println("Size is: " + a1.size());
		System.out.println("Array is Empthy: " + a1.isEmpty());
		System.out.println("Current stacks values is: " + a1.peek());
		System.out.println();
		a1.push(i3);
		System.out.println("Size is: " + a1.size());
		System.out.println("Array is Empthy: " + a1.isEmpty());
		System.out.println("Current stacks values is: " + a1.peek());
		System.out.println();
		a1.push(i4);
		System.out.println("Size is: " + a1.size());
		System.out.println("Array is Empthy: " + a1.isEmpty());
		System.out.println("Current stacks values is: " + a1.peek());
		System.out.println();
		a1.push(i5);
		System.out.println("Size is: " + a1.size());
		System.out.println("Array is Empthy: " + a1.isEmpty());
		System.out.println("Current stacks values is: " + a1.peek());
		System.out.println();
		a1.push(i6);
		System.out.println("Size is: " + a1.size());
		System.out.println("Array is Empthy: " + a1.isEmpty());
		System.out.println("Current stacks values is: " + a1.peek());
		System.out.println();
		
		System.out.println(checkParenteses("({)}"));
		System.out.println(checkParenteses("(3+{5{99{*}}[23[{67}67]]})"));

	}

	public static boolean checkParenteses(String s) {
		ArrayStack a1 = new ArrayStack();
		String s1 = s;
		char venstreAlParantes = '(';
		char højreAlParantes = ')';
		char venstreTuborgKlamme = '{';
		char højreTuborgKlamme = '}';
		char venstreFirParantes = '[';
		char højreFirParantes = ']';

		for (int i = 0; i < s.length(); i++) {
			if (s1.charAt(i) == venstreAlParantes) {
				a1.push(s1.charAt(i));
			}
			if (s1.charAt(i) == højreAlParantes) {
				if(a1.peek() == (Object)venstreAlParantes) {
					a1.pop();
				} else return false;
			}
			if (s1.charAt(i) == venstreTuborgKlamme) {
				a1.push(s1.charAt(i));
			}
			if (s1.charAt(i) == højreTuborgKlamme) {
				if(a1.peek() == (Object)venstreTuborgKlamme) {
					a1.pop();
				} else return false;
			}
			if (s1.charAt(i) == venstreFirParantes) {
				a1.push(s1.charAt(i));
			}
			if (s1.charAt(i) == højreFirParantes) {
				if(a1.peek() == (Object)venstreFirParantes) {
					a1.pop();
				} else return false;
			}
		}
		return a1.isEmpty();
	}

}
