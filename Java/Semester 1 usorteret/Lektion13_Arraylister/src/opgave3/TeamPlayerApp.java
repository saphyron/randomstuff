package opgave3;

public class TeamPlayerApp {

	public static void main(String[] args) {
		Player p1 = new Player("John Høeg", 29); //John som spiller der er 29
		Player p2 = new Player("Mikkel Hansen", 25);
		Player p3 = new Player("Thor", 21);
		
		System.out.println("Player 1 er: " + p1.getName() + ".");
		System.out.println(p1.getName() + " Er " + p1.getAge() + " år gammel.");
		System.out.println(p1.getName() + " Har en score på: " + p1.getScore() + ".");
		p1.addScore(3);
		System.out.println(p1.getName() + "s score er " + p1.getScore() + ".");
		
		System.out.println("- - - - - - - - - - - - - - - - - -");
		
		Team t1 = new Team("Viby");
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.addPlayer(p3);		
		p1.addScore(8);
		p2.addScore(3);
		p3.addScore(1);
		t1.printPlayers();
		System.out.println("Den total score mellem alle spillere er: " + t1.calcTotalScore());
		System.out.println("Gennemsnidtet af spillernes score er: " + t1.calcAverage());
		System.out.println("Den total score for de spillere over 22 er: " + t1.calcOldPlayersScore(22));
		System.out.println("Den spiller der har den højeste score har: " + t1.maxScore());
		System.out.println("Den bedste spiller på holdet er: " + t1.bestPlayer());
	}

}
