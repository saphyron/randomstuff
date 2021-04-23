package eksempel1;

public class VisBesked extends Thread {

	private String besked;

	public VisBesked(String besked) {
		super();
		this.besked = besked;
	}

	public void run() {
		int i = 0;
		while (i<30) {
			System.out.println(besked);
			i++;
		}
	}

}
