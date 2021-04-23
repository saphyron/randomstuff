package eksempel1;

public class TestTraade {

	public static void main(String[] args) throws InterruptedException {
		
		Thread hello = new VisBesked("Hello");
		hello.setName("hello");
		System.out.println("Starter hello traaden ...");
		
		
		Thread goodbye = new VisBesked("Goodbye");
		goodbye.setName("goodbye");
		System.out.println("Starter goodbye traaden ...");
		
		
		Thread traad3 = new GaetEtTal(27);
		traad3.setName("Traad 3");
		System.out.println("Tr�d 3 starter ...");
		
				
		Thread traad4 = new GaetEtTal(42);
		traad4.setName("Traad 4");
		System.out.println("Tr�d 4 starter ...");
		hello.start();
		goodbye.start();
		traad3.start();
		traad3.join(); //Almindelig måde at vente på en tråd bliver færdig
		while (traad3.isAlive()) { //Ualmindelig måde der virker men ikke bliver brugt ofte	
		}
		traad4.start();	
		
	}
}
