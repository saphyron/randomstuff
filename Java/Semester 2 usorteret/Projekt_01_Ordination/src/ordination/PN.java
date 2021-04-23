package ordination;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination {

	List<LocalDate> tidspunkter = new ArrayList<>();
	private double antalEnheder;

	public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antal) {
		super(startDen, slutDen);
		if (antal < 0) {
			throw new IllegalArgumentException("Negativ enhed");
		}
		this.antalEnheder = antal;
		setLaegemiddel(laegemiddel);
	}

	/**
	 * Registrerer at der er givet en dosis paa dagen givesDen Returnerer true hvis
	 * givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
	 * Retrurner false ellers og datoen givesDen ignoreres
	 * 
	 * @param givesDen
	 * @return
	 */


	public boolean givDosis(LocalDate givesDen) {
		if (givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen())) {
			tidspunkter.add(givesDen);
		} else {
			return false;
		}
		return true;
	}

	public double doegnDosis() {
		int daysBetween = antalDage();
		if (daysBetween == 0) {
			System.err.println("Kritisk fejl, dage imellem er 0");
			return -1;
		}
		return tidspunkter.size() * antalEnheder / daysBetween;
	}
	
	public double samletDosis() {
		return tidspunkter.size() * antalEnheder;
	}

	/**
	 * Returnerer antal gange ordinationen er anvendt
	 * 
	 * @return
	 */
	public int getAntalGangeGivet() {
		return tidspunkter.size();
	}

	public double getAntalEnheder() {
		return antalEnheder;
	}

	@Override
	public String getType() {
		return "PN";
	}

	public List<LocalDate> getTidspunkter() {
		return tidspunkter;
	}

	public void addTidspunkt(LocalDate date) {
		givDosis(date);
	}
}