package modelchild;

public class Institution {
	
	private String navn;
	private String addresse;
	private Child[] childArray;
	private int antalBørn;
	private static final int MAX_BØRN = 100;

	public Institution(String navn, String addresse) {
		this.navn = navn;
		this.addresse = addresse;
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
		if (antalBørn < MAX_BØRN) {
			childArray[antalBørn] = child;
			antalBørn++;			
		}
	}
	
	public double averageAge() {
		int sum = 0;
        double average = 0.0;
        for (int i = 0; i < antalBørn; i++) {
            sum = sum + childArray[i].getAge();
        }
        if (antalBørn > 0) {
            average = (double) sum / antalBørn;
        }
		return average;
	}
	
	public int numberOfGirls() {
		int girls = 0;
		for (int i =0; i < antalBørn; i++) {
			if (!childArray[i].isBoy()) {
				girls++;
			}
		}
		return girls;
	}
	
	public int numberOfBoys() {
		int boys = 0;
		for (int i = 0; i < antalBørn; i++) {
			if(childArray[i].isBoy()) {
				boys++;
			}
		}
		return boys;
	}

}
