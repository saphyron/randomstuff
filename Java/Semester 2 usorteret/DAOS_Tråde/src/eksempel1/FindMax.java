package eksempel1;

import java.util.Random;

public class FindMax {
	private static final int rowWidth = 8;
	private static final int colHeight = 20000000;
	private static int[][] board = new int[rowWidth][colHeight];

	public static void main(String[] args) throws InterruptedException {
		fillBoard();
// printBoard();
		long l1 = System.nanoTime();
		System.out.println("FindThreadMax " + findMaxThread());
		long l2 = System.nanoTime();
		System.out.println("Køretiden var " + (l2 - l1) / 1000000 + " millisekunder");

		long l3 = System.nanoTime();
		System.out.println("Max: " + findMax());
		long l4 = System.nanoTime();
		System.out.println("Køretiden var " + (l4 - l3) / 1000000 + " millisekunder");

	}

	public static int findMax() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}

	public static void fillBoard() {
		Random rand = new Random();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = rand.nextInt(200000000);
			}
		}
	}

	public static int findMaxThread() throws InterruptedException {
		int max = Integer.MIN_VALUE;
		SlaveMaster sm = new SlaveMaster(rowWidth, board);
		sm.init();
		max = sm.getMax();
		return max;
	}

	public static void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
