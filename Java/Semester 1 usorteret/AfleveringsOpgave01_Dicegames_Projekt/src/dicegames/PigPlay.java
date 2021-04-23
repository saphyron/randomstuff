package dicegames;

public class PigPlay {
	
	private Die die;
	private int totalSum;
	private int roundSum;
	private int rolls;
	private int rounds;
	private String name;
	private int currentEyes;
	private int roundRolls;
	
	public PigPlay(String name) {
		this.name = name;
		totalSum = 0;
		roundSum = 0;
		rolls = 0;
		rounds = 0;
		currentEyes = 0;
		roundRolls = 0;
		die = new Die();
	}
	
	public int takeTurn() {
		int eyes = 0;
		die.roll();
		eyes = die.getFaceValue();
		if (eyes > 1) {
			roundSum = roundSum + eyes;
		} else {
			roundSum = 0;
		}
		rolls++;
		roundRolls++;
		return eyes;
	}
	
	public void endTurn() {
			totalSum = roundSum + totalSum;
			rounds++;
			roundSum = 0;
			roundRolls = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRoundSum() {
		return roundSum;
	}
	
	public int getTotalSum() {
		return totalSum;
	}
	
	public int getCurrentEyes() {
		currentEyes = die.getFaceValue();
		return currentEyes;
	}
	
	public int getRoundRolls() {
		return roundRolls;
	}
	
	public void printStats() {
		System.out.println("Statistik for " + name);
		System.out.println("Du har kastet " + rolls + " gange.");
		System.out.println("Du har spillet " + rounds + " runder.");
		System.out.println("Du har " + totalSum + " point.");
	}

}
