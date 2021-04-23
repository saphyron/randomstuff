package modelchild;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy
	private double[] weight = {4.2,5.8,9.4,17.1,21.4,25.1,28.4,31.8,35.4,41.0};
	private static final int MAX_AGE = 10;

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}
	
	public double getWeight(int age) {
		return weight[age];
	}
	
	public double getIncrease() {
		double biggestIncrease = 0;
		for (int i = 0; i < MAX_AGE - 1; i++) {
    		if (biggestIncrease < weight[(int)i+1] - weight[(int)i]) {
    			biggestIncrease = weight[(int)i+1] - weight[(int)i];
    		}
    	}
		return biggestIncrease;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

}
