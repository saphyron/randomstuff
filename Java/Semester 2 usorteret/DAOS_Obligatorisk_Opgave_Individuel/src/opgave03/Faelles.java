package opgave03;
import java.util.Random;

public class Faelles {
	
	private int taeller = 0;
	
	public Faelles () {
	}
	/**
	 * Metode der får tråden til at tage tid så der kan forekomme fejl
	 * som er synchroniseret.
	 * @param max int værdi der bruges til at udregne max
	 */
	public synchronized void tagerRandomTid(int max) {
		Random r = new Random();
		int tal = 0;
		int nymax = Math.abs(r.nextInt())% max +1;
		for (int i = 0; i < nymax;i++) {
			for (int j = 0; j < nymax;j++) {
				tal += 1;
			}
		}
	}
	/*
	 * Metode der henter taeller
	 * som er synchroniseret.
	 */
	public synchronized int getTaeller() {
		return taeller;
	}
	/*
	 * Metode der skal lave den kritiske section
	 * som er synchroniseret.
	 */
	public synchronized void kritiskSection() {
		int temp;
		temp = taeller;
		tagerRandomTid(100);
		taeller = temp + 1;
	}
}
