package eksemplerUndervisning;

public class VareApp {

	public static void main(String[] args) {
		Vare.setMoms(0.40);
		
		Vare chocolade = new Vare("Fint Sort Chocolade", 40);
		System.out.println(chocolade.beregnMoms());
		Vare moelk = new Vare("Moelk", 5);
		System.out.println(moelk.beregnMoms());
		
		

	}

}
