package dicegames;

import java.util.Scanner;

public class CrapsPlay {
	private Die die1;
	private Die die2;
	
	int rolls;
	int ditTal;
	private boolean won;
	private boolean finished = false;
	
	Scanner scan = new Scanner(System.in);
	
	public CrapsPlay() {
		die1 = new Die();
		die2 = new Die();
	}
	
	public void welcomeToTheGame() {
		System.out.println("Velkommen til vores baggyde!");
		System.out.println("Her kan du spille craps. Du kan slå med to terninger.");
		System.out.println("Hvis du starter med at slå 7 eller 11, har du vundet.");
		System.out.println("Hvis du starter med at slå 2, 3 eller 12, har du tabt.");
		System.out.println("Hvis du starter med at slå 4, 5, 6, 8, 9 eller 10, defineres dette som dit tal.");
		System.out.println("Herefter slår du indtil: du slår 7, hvilket betyder du har tabt.");
		System.out.println("Eller indtil du slår dit tal, hvilket betyder du har vundet.");
	}
	
	public void gameOver() {
		
		if (won) {
			System.out.println("Tillyke! Du har vundet.");
		} else {
			System.out.println("Ærgerligt. Du har tabt.");
		}
	}
	
	public void takeTurn() {
		rollDice();
		if (rolls == 0) {
			if (sumOfDice() == 7 || sumOfDice() == 11) {
				won = true;
				finished = true;
				System.out.println("Du slog " + sumOfDice());
				gameOver();
			} else if (sumOfDice() == 2 || sumOfDice() == 3 || sumOfDice() == 12) {
				won = false;
				finished = true;
				System.out.println("Du slog " + sumOfDice());
				gameOver();
			} else {
				ditTal = sumOfDice();
				System.out.println("Du slog " + sumOfDice());
				rolls++;
				inputTakeTurn();
			} 
		} 
			else {
				if (sumOfDice() == 7) {
					won = false;
					finished = true;
					System.out.println("Du slog " + sumOfDice());
					gameOver();
				} else {
					if (ditTal == sumOfDice()) {
						won = true;
						finished = true;
						System.out.println("Du slog " + sumOfDice());
						gameOver();
					} else {
						rolls++;
						System.out.println("Du slog " + sumOfDice());
						inputTakeTurn();
					}
				}
			}
	}
	
	public void rollDice() {
		die1.roll();
		die2.roll();
	}
	
	public int sumOfDice() {
		int sum = 0;
		sum = die1.getFaceValue() + die2.getFaceValue();
		return sum;
	}
	
	public void inputTakeTurn() {

		
		while (!finished) {
			System.out.println("Indtast ja hvis du vil kaste: ");			
			String input = scan.nextLine();
			
			if (input.equalsIgnoreCase("ja")) {
				takeTurn();
				
				/*
				if (won) {
					gameOver();
					finished = true;
				} else if (){
					gameOver();
					finished = true;
				} 
			} else {
				System.out.println("WHAT");
				takeTurn();
				*/
			}
		}
	}
	
	public void startGame() {
		welcomeToTheGame();
		
		inputTakeTurn();
			}
		
	
}
