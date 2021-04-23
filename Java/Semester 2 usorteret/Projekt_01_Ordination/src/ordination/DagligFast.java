package ordination;

import java.time.*;


public class DagligFast extends Ordination {

	private Dosis[] doser = new Dosis[4];

	public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel,
			double morgenAntal, double middagAntal, double aftenAntal, double natAntal)  {
		super(startDen, slutDen);
		if (morgenAntal + middagAntal + aftenAntal + natAntal > 4) {
			throw new IllegalArgumentException("Samlet dosis er over 4");
		}
		if (morgenAntal < 0) {
			throw new IllegalArgumentException("Morgen dosis er negativ");
		} 
		if (middagAntal < 0) {
			throw new IllegalArgumentException("Morgen dosis er negativ");
		} 
		if (aftenAntal < 0) {	
		} 
		if (natAntal < 0) {
		}		
		setLaegemiddel(laegemiddel);
		doser = new Dosis[] { new Dosis(LocalTime.of(8, 0), morgenAntal), new Dosis(LocalTime.of(11, 0), middagAntal), 
			new Dosis(LocalTime.of(17, 0), aftenAntal) , new Dosis(LocalTime.of(23, 0), natAntal)};
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
		return (double) samletDosis() / super.antalDage();
	}

	@Override
	public String getType() {
		return "Dalig Fast";
	}

	public void createDosis(Dosis dosis) {
		for (int i = 0; i < doser.length; i++) {
			if (doser[i] != null) {
				doser[i] = dosis;
				return;
			}
		}
	}

	public Dosis[] getDoser() {
		return doser;
		}
	
	public void removeDosis(Dosis dosis) {
		for (int i = 0; i < doser.length; i++) {
			if (doser[i].equals(dosis)) {
				doser[i] = null;
				return;
			}
		}
	}

}
