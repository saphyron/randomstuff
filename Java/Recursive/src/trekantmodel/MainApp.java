package trekantmodel;

public class MainApp {
	
	//Fun1
//	public static int fun(int n) {
//		if (n == 4) return n;
//		else return 2 * fun(n + 1);
//	}

	// Fun2
//	public static int fun(int x, int y) {
//		if (y == 0) return 0;
//		return (x + fun(x, y-1));
//	}

	// Fun1
//	public static void main(String[] args) {
//		System.out.println(fun(2));
//
//	}
	
	// Fun2
//	public static void main(String[] args) {
//		System.out.println(fun(2, 3));
//
//	}
	
	public static void main(String[] args) {
		Trekant t = new Trekant(10);
		int area = t.getArea();
		System.out.println("Area: " + area);
		System.out.println("Expected: 55");
	}

}
