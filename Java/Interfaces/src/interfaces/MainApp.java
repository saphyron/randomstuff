package interfaces;

public class MainApp {

	public static void main(String[] args) {
		Measurable[] m = new Measurable[6];
		Chili c1 = new Chili("Test1", 500);
		Chili c2 = new Chili("Test2", 5000);
		Chili c3 = new Chili("Test3", 50000);
		Chili c4 = new Chili("Test4", 500000);
		Chili c5 = new Chili("Test5", 1000000);
		Chili c6 = new Chili("Test6", 2000000);
		m[0] = c1;
		m[1] = c2;
		m[2] = c3;
		m[3] = c4;
		m[4] = c5;
		m[5] = c6;
		
		System.out.println(Data.max(m).toString());
		System.out.println("Average Scoville styke er: " + Data.avg(m) + ".");
	}

}
