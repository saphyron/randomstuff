package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DagligSkaev extends Ordination {

	private List<Dosis> doser = new ArrayList<>();
	
	public DagligSkaev(LocalDate startDen, LocalDate slutDen) {
		super(startDen, slutDen);
	}
	
	public DagligSkaev(LocalDate startDen, LocalDate slutDen, 
			Laegemiddel laegemiddel, LocalTime[] klokkeSlet, double[] antalEnheder) {
		super(startDen, slutDen);
		for (double enhed : antalEnheder) {
			if (enhed < 0) {
				throw new IllegalArgumentException("negativ enhed fundet");
			}
		}
		for (int i = 0; i < klokkeSlet.length; i++) {
			opretDosis(klokkeSlet[i], antalEnheder[i]);
		}
		setLaegemiddel(laegemiddel);
	}

	public void opretDosis(LocalTime tid, double antal) {
		doser.add(new Dosis(tid, antal));
	}

	@Override
	public double samletDosis() {
		double sum = 0;
		for (Dosis dose : doser) {
			sum += dose.getAntal();
		}
		return sum;
	}

	@Override
	public double doegnDosis() {
		int antalDage = super.antalDage();
		if (antalDage == 0) {
			throw new RuntimeException("må ikke dividerer med 0");
		}
		return samletDosis() / super.antalDage();
	}

	@Override
	public String getType() {
		return "Dalig skæv123";
	}

	public void createDosis(Dosis dosis) {
		if (!doser.contains(dosis)) {
			doser.add(dosis);
		}
	}

	public List<Dosis> getDoser() {
		return doser;
	}
	
	public void removeDosis(Dosis dosis) {
		if (doser.contains(dosis)) {
			doser.remove(dosis);
		}
	}
}