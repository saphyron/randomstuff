package dicegames;



/**
 * This class models one pair of dices.
 *
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
	private Die die1;
	/**
	 * The second die in the pair.
	 */
	private Die die2;

	// (til opgave 1.3) <---
	private int totalRolls; 
	// (til opgave 1.4) <---
	private int sixEyes;
	// (til opgave 1.5) <---
	private int fiveEyes;
	private int fourEyes;
	private int threeEyes;
	private int twoEyes;
	private int oneEye;
	// (til opgave 1.6) <---
	private int sameEyes;
	// (til opgave 1.7) <---
	private int maxEyes;
	/**
	 * Constructor for objects of class PairOfDices
	 */
	public PairOfDices() {
		die1 = new Die(6);
		die2 = new Die(6);
		sixEyes = 0; //opgave 1.4 
		fiveEyes = 0; // opgave 1.5
		fourEyes = 0; // opgave 1.5
		threeEyes = 0; // opgave 1.5
		twoEyes = 0; // opgave 1.5
		oneEye = 0; // opgave 1.5
		maxEyes = 0; // opgave 1.7
		sameEyes = 0; // opgave 1.6
	}
	
	// Opgave 1.1
	public void rollBothDice() {
		die1.roll();
		die2.roll();
		totalRolls++; //(opgave 1.3)
		getEyes();
				
	}
	// Opgave 1.2
	public int sumOfDice() {
		int sum = 0;
		sum = die1.getFaceValue() + die2.getFaceValue();
		
		return sum;
	}
	
	public int die1Eyes() {
		int die1Eyes = die1.getFaceValue();
		return die1Eyes;
	}
	
	public int die2Eyes() {
		int die2Eyes = die2.getFaceValue();
		return die2Eyes;
	}
	// Opgave 1.4 & 1.5 & 1.6
	public void getEyes() {
		if (die1.getFaceValue() == 6){
			sixEyes++;
		}
		else if (die1.getFaceValue() == 5){
			fiveEyes++;
		}
		else if (die1.getFaceValue() == 4){
			fourEyes++;
		}
		else if (die1.getFaceValue() == 3){
			threeEyes++;
		}
		else if (die1.getFaceValue() == 2){
			twoEyes++;
		}
		else if (die1.getFaceValue() == 1){
			oneEye++;
		}
		if (die2.getFaceValue() == 6){
			sixEyes++;
		}
		else if (die2.getFaceValue() == 5){
			fiveEyes++;
		}
		else if (die2.getFaceValue() == 4){
			fourEyes++;
		}
		else if (die2.getFaceValue() == 3){
			threeEyes++;
		}
		else if (die2.getFaceValue() == 2){
			twoEyes++;
		}
		else if (die2.getFaceValue() == 1){
			oneEye++;
		}
		if (die1.getFaceValue()==die2.getFaceValue()) { // opgave 1.6
			sameEyes++;
		}
		if (maxEyes<sumOfDice()) { // opgave 1.7
			maxEyes = sumOfDice();
		}
			
	}
	// opgave 1.8
	public void resetPairOfDice() {
		sixEyes = 0;  
		fiveEyes = 0; 
		fourEyes = 0;	
		threeEyes = 0; 
		twoEyes = 0; 
		oneEye = 0; 
		maxEyes = 0;
		totalRolls = 0;
		sameEyes = 0;
	}
	
	public int getSameEyes() {
		return sameEyes;
	}
	
	public int getSixEyes() {
		return sixEyes;
	}
	
	public int getFiveEyes() {
		return fiveEyes;
	}
	
	public int getFourEyes() {
		return fourEyes;
	}
	
	public int getThreeEyes() {
		return threeEyes;
	}
	
	public int getTwoEyes() {
		return twoEyes;
	}
	
	public int getOneEye() {
		return oneEye;
	}
	
	public int getMaxEyes() {
		return maxEyes;
	}
	
	public int getTotalRolls() {
		return totalRolls;
	}
		
	
	
	
	
	
	
	
	
	
}
