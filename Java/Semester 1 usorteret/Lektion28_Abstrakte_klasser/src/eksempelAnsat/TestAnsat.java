package eksempelAnsat;

public class TestAnsat {

	public static void main(String[] args) {
		
		Ansat ta1 = new TimeAnsat("Ole", "Olesen", "0989876", 100, 37);
		System.out.println(ta1);
		System.out.println("Udbetaling: " + ta1.udregnLoen());
		
		System.out.println("---------------------------------");
		
		Ansat ka2 = new KommissionAnsat("Finn", "Finnsen", "0909878", 600, 130);
		System.out.println(ka2);
		System.out.println("Udbetaling: " + ka2.udregnLoen());
		
		System.out.println("---------------------------------");
		
		Ansat pka3 = new PlusKommissionAnsat("Lars", "Larsen", "00989876", 600, 130, 450);
		System.out.println(pka3);
		System.out.println("Udbetaling: " + pka3.udregnLoen());

	}

}
