package dicegames;
import java.util.Scanner;

public class PlayPairOfDice {
	
	private Scanner scan;
	private String name;
	private PairOfDices dices;
	
	public PlayPairOfDice() {
		dices = new PairOfDices();
		scan = new Scanner(System.in);
		
	}
		
	
	public void welcome() {
		System.out.println("Hej! Hvad er dit navn?");
		Scanner scan1 = new Scanner(System.in);
		name = scan1.nextLine();
		System.out.println("Velkommen " + name + " til vores baggyde :-P");
		scan1.close();
	}
	
	private void gameOver() {
		System.out.println("Tak fordi du spillede vores gydespil.");
		System.out.println("Her er nogle statistikker over dit spil:");
		System.out.println("Du har slået to ens " + dices.getSameEyes() + " gange.");
		System.out.println("Du har slået seks " + dices.getSixEyes() + " gange.");
		System.out.println("Du har slået fem " + dices.getFiveEyes() + " gange.");
		System.out.println("Du har slået fire " + dices.getFourEyes() + " gange.");
		System.out.println("Du har slået tre " + dices.getThreeEyes() + " gange.");
		System.out.println("Du har slået to " + dices.getTwoEyes() + " gange.");
		System.out.println("Du har slået en " + dices.getOneEye() + " gange.");
		System.out.println("Du har kastet terningerne " + dices.getTotalRolls() + " gange.");
		System.out.println("Dit højeste slag har været " + dices.getMaxEyes() + ".");
		scan.close();
	}
	
	private void takeNextTurn() {
		dices.rollBothDice();
		int roll1 = dices.die1Eyes();
		int roll2 = dices.die2Eyes();
		System.out.println("Du slog " + roll1 + " og " + roll2);
		
	}
	
	public void startTheGame() {
		welcome();
		
		boolean finished = false;
		
		while (!finished) {
			System.out.println("Tør du at kaste terningerne? Ja eller Nej: ");
			String gameInput = scan.nextLine();
			if (gameInput.equalsIgnoreCase("Nej")) {
				finished = true;
			} else {
				takeNextTurn();
			}
		}
		gameOver();
	}
}
