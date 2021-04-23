package opgave3;

import java.util.ArrayList;

public class Team {
	
	private String navn;
	private ArrayList<Player> players;
	
	public Team(String navn) {
		this.navn = navn;
		players = new ArrayList<Player>();
	}

	public String getNavn() {
		return navn;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void printPlayers() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println("Spiller " + (i + 1) + ": "+ players.get(i).getName() + " er " + players.get(i).getAge() + " år gammel og har score: " + players.get(i).getScore());
		}
	}
	
	public double calcAverage() {
		double average = 0;
    	for (int i = 0; i < players.size(); i++) {
    		int numbers = players.get(i).getScore();
    		average = average + numbers;
    	}
    	average = average / players.size();
    	return average;
	}
	
	public int calcTotalScore() {
		int totalSum = 0;
        for (int i = 0; i < players.size(); i++) {
            int number = players.get(i).getScore();
            totalSum = totalSum + number;
        }
        return totalSum;
	}
	
	public int calcOldPlayersScore (int ageLimit) {
		int totalSumOldPlayers = 0;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getAge() > ageLimit) {
				totalSumOldPlayers = totalSumOldPlayers + players.get(i).getScore();
			}
		}
		return totalSumOldPlayers;
	}
	
	public int maxScore() {
		int maxScoreSum = 0;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getScore() > maxScoreSum) {
				maxScoreSum = players.get(i).getScore();
			}
		}
		return maxScoreSum;
	}
	
	public String bestPlayer() {
		int maxScoreSumBestPlayer = 0;
		String nameOfBestPlayer = "Ingen";
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getScore() > maxScoreSumBestPlayer) {
				maxScoreSumBestPlayer = players.get(i).getScore();
				nameOfBestPlayer = players.get(i).getName();
			}
		}
		return nameOfBestPlayer;
	}

}
