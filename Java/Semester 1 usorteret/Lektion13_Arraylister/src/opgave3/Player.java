package opgave3;

public class Player {
	
	private int age;
	private int score;
	private String name;
	
	public Player(String name, int age) {
		this.name = name;
		this.age = age;
		this.score = 0;		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
	
	public void addScore(int score) {
		this.score = this.score + score;
	}

}
