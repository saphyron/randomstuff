package array_sammnehaeng;

public class MainApp {

	public static void main(String[] args) {

		Team t1 = new Team("Silkeborg IF");
		Player p1 = new Player("John", 29);
		Player p2 = new Player("Andreas", 26);
		Player p3 = new Player("Martin", 35);
		
		p1.addScore(5);
		p2.addScore(3);
		p3.addScore(6);
		
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.addPlayer(p3);
		
		t1.printPlayers();
		System.out.println();
		System.out.println(t1.calcAverageAge());
		System.out.println();
		System.out.println(t1.calcTotalScore());
		System.out.println();
		System.out.println(t1.calcOldPlayersScore(28));
		System.out.println();
		System.out.println(t1.maxScore());
		System.out.println();
		System.out.println(t1.bestPlayer());
	}

}
