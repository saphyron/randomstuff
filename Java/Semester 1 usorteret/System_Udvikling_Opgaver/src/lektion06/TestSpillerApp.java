package lektion06;

public class TestSpillerApp {

	public static void main(String[] args) {
		Spiller s1 = new Spiller("John Høeg", 29);
		s1.printStatus();
		System.out.println("- - - - - - - - - - - - - -");
		
		s1.setPosition("Forsvar");
		s1.setStatus("Aktivt");
		s1.printStatus();

	}

}
