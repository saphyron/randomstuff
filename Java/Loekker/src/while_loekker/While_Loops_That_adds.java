package while_loekker;

public class While_Loops_That_adds {

	public static void main(String[] args) {
		
		//opgave a
		int i = 2;
		int sum = 0;
		while (i < 101) {
			sum = sum + i;
			i = i + 2;
			System.out.println(sum);
		}
		System.out.println(sum);
		//opgave a slut
		
		//opgave b
		int n = 1;
		int sqsum = 0;
		while (n < 101) {
			int square = n*n;
			sqsum += square;
			n++;
			System.out.println(sqsum);
		}
		//opgave b slut
		
		//opgave c
		int j = 0;
		while (j < 21) {
			int potens = (int)Math.pow(2, j);
			j++;
			System.out.println(potens);
		}
		//opgave c slut
		
		//opgave d
		int input01 = 2;
		int input02 = 99;
		int uesum = 0;
		while (input01 < input02) {
			if (input01 % 2 == 0) {
				input01++;
			}
			uesum += input01;
			input01 = input01 + 2;
			System.out.println(uesum);
		}
		//opgave d slut
		
		//opgave e
		int inputodd = 32677;
		int io = 0;
		int oddsum = 0;
		while (inputodd > 0) {
			io = inputodd % 10;
			if (io % 2 == 1) {
				oddsum += io;
			}
			inputodd /= 10;
		}
		System.out.println(oddsum);
	}

}
