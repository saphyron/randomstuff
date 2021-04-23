package eksStud;

public class Kunder extends Thread {

	private static int nummer = 10000;
	private int id;
	private TagEtNummer tagEtNummer;

	public Kunder(TagEtNummer dims) {
		id = ++nummer;
		tagEtNummer = dims;
	}

	public void run() {
		try {
			 sleep((int)(Math.random() * 2000));
			// sleep((int) (Math.random() * 10));
			tagEtNummer.naesteNummer(id);
		} catch (InterruptedException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
