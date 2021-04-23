package opgaver;

import java.util.ArrayList;
import java.util.List;

public class Opgave_02_Skole {

	private String navn;
	private ArrayList<Opgave_02_Studerende> studerende = new ArrayList<>();

	public Opgave_02_Skole(String navn) {
		super();
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return "Opgave_02_Skole [navn=" + navn + "]";
	}

	public void addStuderende(Opgave_02_Studerende studerende) {
		if (!this.studerende.contains(studerende)) {
			this.studerende.add(studerende);
		}

	}

	public void removeStuderende(Opgave_02_Studerende studerende) {
		if (this.studerende.contains(studerende)) {
			this.studerende.remove(studerende);
		}
	}

	public double gennemsnit() {
		double tempGns = 0;
		for (int i = 0; i < studerende.size(); i++) {
			for (int j = 0; j < studerende.get(i).getKarakter().size(); j++) {
				double tempdouble = (double) studerende.get(i).getKarakter(j);
				tempGns = tempGns + studerende.get(i).getKarakter((double) j);
			}
		}
		return 1;
	}

	public Opgave_02_Studerende findStuderende(int studieNr) {
		for (int i = 0; i < studerende.size(); i++) {
			if (studerende.get(i).getStudieNr() == studieNr) {
				return studerende.get(i);
			}
		}
		return null;
	}

}
