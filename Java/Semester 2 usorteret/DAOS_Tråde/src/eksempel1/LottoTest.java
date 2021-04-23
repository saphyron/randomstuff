package eksempel1;

import java.util.Random;

public class LottoTest {
	private boolean[] raek = new boolean[37];

	public LottoTest() {
		for (int j = 0; j < 37; j++)
			raek[j] = false;
		int ant = 0;
		Random r = new Random();
		while (ant < 7) {
			int tal = Math.abs(r.nextInt() % 36 + 1);
			if (!raek[tal]) {
				raek[tal] = true;
				ant++;
			}
		}
	}

	public int antalrigtige(LottoTest rigtig) {
		int x = 0;
		for (int j = 1; j < 37; j++)
			if (this.raek[j] && rigtig.raek[j])
				x++;
		return x;
	}
}
