package fletning;

public class Udskriv_Traad extends Thread {

	public Udskriv_Traad() {

	}

	public void run(){
		
		boolean run = true;
		while (run) {
			try {
				sleep(3000);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			System.out.println(Stringen.getNavn());
		}
	}

}
