package application;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
 * Klassen skal give en liste over
 * hvor meget hvert produkt skal
 * koste. Listen er anbragt i
 * et treemap hvor priser med samme
 * produkttype er i samme liste.
 * 
 * @author Gruppe 5
 * @see    Produkt
 * @see    ProduktType
 */

public class Prisliste implements java.io.Serializable {
	
	private static final long serialVersionUID = 123123123;
	private String prislisteNavn;
	private TreeMap<ProduktType, List<Pris>> treeMapPriser = new TreeMap<>();
	/**
	 * Skaber en prisliste.
	 * @param prislisteNavn String der giver navn til prislisten.
	 * @throws IllegalArgumentException hvis navn er tom eller null.
	 */
	public Prisliste(String prislisteNavn) {
		if (prislisteNavn == null) {
			throw new IllegalArgumentException("Fejl! Prisliste instans kan ikke laves: Navn er null");
		}
		if (prislisteNavn.length() == 0) {
			throw new IllegalArgumentException("Fejl! Prisliste instans kan ikke laves: Navn er tom");
		}
		this.prislisteNavn = prislisteNavn;
	}
	/**
	 * Tilføjer en pris til en produkttype.
	 * @param pris er en associations klasse.
	 */
	public void addPris(Pris pris) {
		ProduktType produktType = pris.getProdukt().getProduktType();
		if (!treeMapPriser.containsKey(produktType)) {
			treeMapPriser.put(produktType, new ArrayList<Pris>());
			treeMapPriser.get(produktType).add(pris);
		}
		else {
			treeMapPriser.get(produktType).add(pris);
		}
	}
	/**
	 * Fjerner en pris fra en produkttype.
	 * @param pris er en associations klasse.
	 */
	public void removePris(Pris pris) {
		ProduktType produktType = pris.getProdukt().getProduktType();
		if (!treeMapPriser.containsKey(produktType)) {
			return;
		}
		if (!treeMapPriser.get(produktType).contains(pris)) {
			return;
		}
		treeMapPriser.remove(produktType);
	}

	public TreeMap<ProduktType, List<Pris>> getTreeMapPriser() {
		return treeMapPriser;
	}
	
	@Override
	public String toString() {
		return prislisteNavn;
	}

}
