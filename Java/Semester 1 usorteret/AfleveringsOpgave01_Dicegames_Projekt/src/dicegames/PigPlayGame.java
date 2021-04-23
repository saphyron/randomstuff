package dicegames;
import java.util.Scanner;

public class PigPlayGame {
	
	private PigPlay player1;
	private PigPlay player2;
	private Scanner scan;
	private boolean roundFinished;
	private boolean isPlayer1;
	private boolean gameFinished;
	private boolean gameOver;
	private int maxPoints;
	
	public PigPlayGame(int kPoints) {
		this.maxPoints = kPoints;
		scan = new Scanner(System.in);
	}

	public void welcomeGame() {
		System.out.println("Velkommen til vores baggyde. Her kan du spille Pig.");
		System.out.println("Hver spiller skiftes til at kaste med en terning indtil han enten kaster 1, eller beslutter sig for at\r\n" + 
				"stoppe. Hvis han slår en 1’er, får han ingen point i denne omgang. Hvis han beslutter sig for at\r\n" + 
				"stoppe inden har slår en 1’er, lægges summen af alle hans kast i denne tur sammen med hans\r\n" + 
				"samlede antal point, og turen går videre til næste spiller. Den første spiller der samlet når " + maxPoints + "\r\n" + 
				"point har vundet.");
	}
	
	public void initPlayer1() {
		System.out.print("Indtast navn på spiller1: ");
		String navn = scan.next();
		player1 = new PigPlay(navn);
	}
	
	public void initPlayer2() {
		System.out.print("Indtast navn på spiller2: ");
		String navn = scan.next();
		player2 = new PigPlay(navn);
	}
	
	public void initPlayers() {
		initPlayer1();
		initPlayer2();
		//System.out.println(player1.getName() + player2.getName());
	}
	
	public void startGame() {
		welcomeGame();
		initPlayers();
		while (!gameOver) {
			newGame();
		}
		
	}
	
	public void newGame() {
		gameFinished = false;
		while (!gameFinished && player1.getTotalSum() < maxPoints && player2.getTotalSum() < maxPoints) {
			if (isPlayer1) {
				System.out.println("Turen går til " + player1.getName());
				newRound(player1);
			} else {
				System.out.println("Turen går til " + player2.getName());
				newRound(player2);
			}
		}
	}
	
	public void newRound(PigPlay player) {
		rollDice(player);
		roundFinished = false;
		while (player.getCurrentEyes() != 1 && roundFinished == false && !overMaxPoints(player)) {
			System.out.println(player.getName() + " har slået " + player.getRoundSum() + " indtil videre.");
			System.out.print("Skriv HOLD for at stoppe turen, ellers skriv FORTSÆT: ");
			String input = scan.next();
			if (input.equalsIgnoreCase("fortsæt")) {
					rollDice(player);
				} else if (input.equalsIgnoreCase("hold")) {
					endTurn(player);
					roundFinished = true;
				}
		}
		if (player.getCurrentEyes() == 1) {
			System.out.println("Du slog 1, og har derfor mistet din tur!");
			roundFinished = true;
			endTurn(player);
		}
		if (overMaxPoints(player)) {
			gameWon(player);
		}
	}
	
	public boolean overMaxPoints (PigPlay player) {
		boolean over;
		if ((player.getTotalSum() + player.getRoundSum()) >= maxPoints) {
			over = true;
		} else {
			over = false;
		}
		return over;
	}
	
	public void rollDice(PigPlay player) {
		if (player.getRoundRolls() == 0) {
			System.out.print("Skriv go for at kaste: ");
			String input = scan.next();
			if (input.equalsIgnoreCase("go")) {
				player.takeTurn();
				System.out.println("Du slog: " + player.getCurrentEyes());
			} else {
				System.out.println("Du skal skrive go!");
				rollDice(player);
			}
		} else {
			player.takeTurn();
			System.out.println("Du slog: " + player.getCurrentEyes());
		}
		
	}
	
	public void endTurn(PigPlay player) {
		System.out.println("Din tur er slut.");
		System.out.print(player.getName() + " fik " + player.getRoundSum() + " point i denne runde. ");
		player.endTurn();
		System.out.println("Du har nu " + player.getTotalSum() + " point i det hele.");
		changePlayer();
	}
	
	public void printStats() {
		player1.printStats();
		player2.printStats();
	}
	
	public void changePlayer() {
		if (isPlayer1) {
			isPlayer1 = false;
		} else {
			isPlayer1 = true;
		}
	}
	
	public void gameWon(PigPlay player) {
		endTurn(player);
		System.out.println("Tillykke " + player.getName() + " du har vundet spillet!");
		printStats();
		gameOver = true;
		roundFinished = true;
		gameFinished = true;
		scan.close();
	}
	
}
