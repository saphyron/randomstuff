package dicegames;

import java.util.Scanner;

public class PigPlayApp {

	//Her vælger vi hvor mange points der skal til for at vinde.
	//Denne metode starter også spillet.
	public static void main(String[] args) {
		int kPoints = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("Indtast hvor mange points i vil spille til: "); 
		kPoints = scan.nextInt();
		PigPlayGame spil = new PigPlayGame(kPoints);
		spil.startGame();
		scan.close();
	}

}
