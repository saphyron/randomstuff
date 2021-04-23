package eksStud;

public class TagEtNummer {

	private int naeste = 0;
	private int betjening = 0;

	public synchronized int naesteNummer(int kundeId) {
		naeste = naeste + 1;
		System.out.println("Kunde " + kundeId + " tager nummer " + naeste);
		notify();
		return naeste;
	}

	public synchronized int naesteKunde() {
		try {
			if (naeste <= betjening) {
				System.out.println("  Ekspedient venter ");
				try {
					wait();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}

		} finally {
			++betjening;
			System.out.println("  Ekspedient ekspederer nummer " + betjening);
		}
		return betjening;
	}
}
