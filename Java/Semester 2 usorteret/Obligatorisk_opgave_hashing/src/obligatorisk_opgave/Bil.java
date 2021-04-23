package obligatorisk_opgave;

public class Bil {
	
	private String registreringsNummer;
	private String maerke;
	private String model;
	private String farve;
	/**
	 * @param registreringsNummer
	 * @param maerke
	 * @param model
	 * @param farve
	 */
	public Bil(String registreringsNummer, String maerke, String model, String farve) {
		this.registreringsNummer = registreringsNummer;
		this.maerke = maerke;
		this.model = model;
		this.farve = farve;
	}
	public String getRegistreringsNummer() {
		return registreringsNummer;
	}
	public void setRegistreringsNummer(String registreringsNummer) {
		this.registreringsNummer = registreringsNummer;
	}
	public String getMaerke() {
		return maerke;
	}
	public void setMaerke(String maerke) {
		this.maerke = maerke;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFarve() {
		return farve;
	}
	public void setFarve(String farve) {
		this.farve = farve;
	}
	@Override
	public String toString() {
		return " [registreringsNummer=" + registreringsNummer + ", maerke=" + maerke + ", model=" + model
				+ ", farve=" + farve + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((farve == null) ? 0 : farve.hashCode());
		result = prime * result + ((maerke == null) ? 0 : maerke.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((registreringsNummer == null) ? 0 : registreringsNummer.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bil other = (Bil) obj;
		if (farve == null) {
			if (other.farve != null)
				return false;
		} else if (!farve.equals(other.farve))
			return false;
		if (maerke == null) {
			if (other.maerke != null)
				return false;
		} else if (!maerke.equals(other.maerke))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (registreringsNummer == null) {
			if (other.registreringsNummer != null)
				return false;
		} else if (!registreringsNummer.equals(other.registreringsNummer))
			return false;
		return true;
	}
	
	

}
