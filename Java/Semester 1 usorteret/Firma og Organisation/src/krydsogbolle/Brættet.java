package krydsogbolle;


public class Brættet {
	private int[][] bræt;
	
	
	public Brættet() {
		this.bræt = new int[3][3];
		int[][] temp = { { 0,0,0 }, { 0,0,0 }, { 0,0,0 } };
		this.bræt = temp;
		
	}
	
	public void printBræt() {
		for (int i =0; i < bræt.length; i++) {
			for (int j = 0; j < bræt[0].length; j++) {
				System.out.print(bræt[i][j] + " ");
			}
			System.out.println();
		}
	}

}
