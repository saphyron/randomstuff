package model;

import java.util.ArrayList;

public class Ledsager {

	private String navn;
	//association -->0..* Udflugt (many-to-many)
	private final ArrayList<Udflugt> udflugter;
	
	
	public Ledsager(String navn) {
		this.navn = navn;
		udflugter = new ArrayList<>();
	}
	
	public double totalUdflugtspris() {
		double pris = 0;
		
		for(int i = 0; i < udflugter.size() ; i++) {
			pris += udflugter.get(i).getPris();
		}
		
		return pris;
	}
	
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	//get-metoder
	
	public String getNavn() {
		return navn;
	}
	
	
	//Association -->0..* Udflugt (dobbelt-rettet: many-to-many)
	
	public ArrayList<Udflugt> getUdflugt(){
		return new ArrayList<>(udflugter);
	}
	
	public void addUdflugt(Udflugt udflugt) {
		if(!udflugter.contains(udflugt)) {
			udflugter.add(udflugt);
			udflugt.addLedsager(this);
		}
	}
	
	public void removeUdflugt(Udflugt udflugt) {
		if(udflugter.contains(udflugt)) {
			udflugter.remove(udflugt);
		}
	}
	

}
