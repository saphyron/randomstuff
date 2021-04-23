package opgave02;

import java.util.Random;

public class Faelles {
	
	private boolean flag[];
	private int turn;
	private int taeller = 0;
	
	public Faelles () {
		flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
	}
	/**
	 * Metode der får tråden til at tage tid så der kan forekomme fejl
	 * @param max int værdi der bruges til at udregne max
	 */
	public void tagerRandomTid(int max) {
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
	 */
	public int getTaeller() {
		return taeller;
	}
	/*
	 * Metode der skal lave den kritiske section
	 */	
	public void kritiskSection() {
		int temp;
		temp = taeller;
		tagerRandomTid(100);
		taeller = temp + 1;
	}
	/**
	 * Metode der sætter flag[id] til falsk eller sandt
	 * @param flag, boolean array bruges til at spørge om falsk eller sandt
	 * @param id, int bruges til at identificer specific flag.
	 */
	public void setFlag(boolean flag, int id) {
		this.flag[id] = flag;
	}
	/**
	 * Simpel get flag metode
	 * @param id, int bruges til at identificer specific flag.
	 * @return sandt eller falsk på bestemt id
	 */
	public boolean getFlag(int id) {
		return flag[id];
	}
	/**
	 * Metode der sætter turn til 1 eller 0
	 * @param turn, int der bruges til hvems tur det er.
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}
	/**
	 * Simpel get turn metode
	 * @return turn.
	 */
	public int getTurn() {
		return turn;
	}
}
