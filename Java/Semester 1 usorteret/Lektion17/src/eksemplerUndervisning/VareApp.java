package eksemplerUndervisning;

public class VareApp {

	public static void main(String[] args) {
		Vare.setMoms(0.40);
		
		Vare chocolade = new Vare("Fint Sort Chocolade", 40);
		System.out.println(chocolade.beregnMoms());
		Vare m�lk = new Vare("M�lk", 5);
		System.out.println(m�lk.beregnMoms());
		
		

	}

}
