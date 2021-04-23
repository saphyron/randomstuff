package array_sammnehaeng;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> player;

	public Team(String name) {
		super();
		this.name = name;
		player = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPlayer(Player player) {
		this.player.add(player);
	}

	public void printPlayers() {
		for (int i = 0; i < player.size(); i++) {
			System.out.println("Players name is: " + player.get(i).getName() + ", and are " + player.get(i).getAge()
					+ " years old, and have a score of: " + player.get(i).getScore());
		}
	}

	public double calcAverageAge() {
		double sum = 0;
		double total = 0;
		for (Player i : player) {
			sum += i.getAge();
			total++;
		}
		return sum / total;
	}

	public int calcTotalScore() {
		int sum = 0;
		for (Player i : player) {
			sum += i.getScore();
		}
		return sum;
	}

	public int calcOldPlayersScore(int ageLimit) {
		int sum = 0;
		for (Player i : player) {
			if (i.getAge() > ageLimit) {
				sum += i.getScore();
			}
		}
		return sum;
	}

	public int maxScore() {
		int sum = Integer.MIN_VALUE;
		for (Player i : player) {
			if (i.getScore() > sum) {
				sum = i.getScore();
			}
		}
		return sum;
	}
	
	public String bestPlayer() {
		int sum = Integer.MIN_VALUE;
		String best = "";
		for (Player i : player) {
			if (i.getScore() > sum) {
				sum = i.getScore();
				best = i.getName();
			}
		}
		return best;
	}

}
