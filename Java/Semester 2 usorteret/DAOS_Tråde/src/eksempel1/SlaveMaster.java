package eksempel1;

public class SlaveMaster {
	private int slaves;
	private int[][] board;
	private int max;

	public SlaveMaster(int slaves, int[][] board) {
		super();
		this.slaves = slaves;
		this.board = board;
	}

	public class Slave extends Thread {
		private int raekke;
		private int max;

		public Slave(int raekke) {
			super();
			this.raekke = raekke;
		}

		public void run() {
			max = Integer.MIN_VALUE;
			for (int j = 0; j < board[raekke].length; j++) {
				max = Math.max(max, board[raekke][j]);
			}
		}

		public int getMax() {
			int max = Integer.MIN_VALUE;
			max = this.max;
			return max;
		}
	}

	public int getMax() {
		return max;
	}

	public void init() throws InterruptedException {
		Slave[] s1 = new Slave[slaves];
		
		for (int i = 0; i < slaves; i++) {
			Slave s = new Slave(i);
			s1[i] = s;
			s.start(); 
			}
		for (int i = 0; i < slaves; i++) {
			s1[i].join();
			if (s1[i].getMax() > this.max) {
				this.max = s1[i].getMax();
			}
		}
		
	}

}
