package modelchild;

public class Institution {
	private String navn;
	private String addresse;
	private Child[] childArray;
	private int antalBoern;
	private static final int MAX_BAARN = 100;

	public Institution(String navn, String addresse) {
		this.navn = navn;
		this.addresse = addresse;
		childArray = new Child[MAX_BAARN];
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getAddresse() {
		return addresse;
	}

	public void addChild(Child child) {
		Child[] childTemp = new Child[MAX_BAARN];
		if (antalBoern < MAX_BAARN) {
			if (childArray != null) {
				for (int i = 0; i < childArray.length; i++) {
					childTemp[i] = childArray[i];
				}
			}
			childTemp[antalBoern] = child;
			antalBoern++;
		}
		childArray = childTemp;
	}

	public double averageAge() {
		int sum = 0;
		double average = 0.0;
		for (int i = 0; i < antalBoern; i++) {
			sum = sum + childArray[i].getAge();
		}
		if (antalBoern > 0) {
			average = (double) sum / antalBoern;
		}
		return average;
	}

	public int numberOfGirls() {
		int girls = 0;
		for (int i = 0; i < antalBoern; i++) {
			if (!childArray[i].isBoy()) {
				girls++;
			}
		}
		return girls;
	}

	public int numberOfBoys() {
		int boys = 0;
		for (int i = 0; i < antalBoern; i++) {
			if (childArray[i].isBoy()) {
				boys++;
			}
		}
		return boys;
	}

}
