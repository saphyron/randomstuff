package eksempel1;

public class MainAppLotto {

	public static void main(String[] args) {
		long l1 = System.nanoTime();
		int antalRaekker = 10000000;
		Object[] lt = new Object[antalRaekker];
		LottoTest[] ltr = new LottoTest[37];
		for (int i = 0; i < antalRaekker; i++) {
			LottoTest lts = new LottoTest();
			lt[i] = lts;
		}
		for (int i = 0; i < lt.length; i++) {
			ltr[i] = (LottoTest) lt[i];
		}
		long l2 = System.nanoTime();
		
		
		
		
		System.out.println("Køretiden var " + (l2 - l1) / 1000000 + " millisekunder");
	}

}
