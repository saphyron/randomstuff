package fletning;

import java.util.Scanner;

public class Tastetur_Traad extends Thread{
	
	public Tastetur_Traad() {
		
	}

	public void run() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("Du har 10sec til at skrive et navn.");
				Scanner sc = new Scanner(System.in);
				if(sc.hasNext()) {
					String navn = sc.nextLine();
					Stringen.setNavn(navn);
				}
				sleep(10000);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		
	}
}
