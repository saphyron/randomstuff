package controller;

import java.time.LocalDate;

import model.Booking_hotel;
import model.Booking_konference;
import model.Deltager;
import model.Hotel;
import model.Konference;
import model.Ledsager;
import model.Serviceydelse;
import model.Udflugt;

public class Test {

	public static void main(String[] args) {

		LocalDate startdato = LocalDate.of(2019, 5, 18);
		LocalDate slutdato = LocalDate.of(2019, 5, 20);
		LocalDate tilmeldingsfrist = LocalDate.of(2019, 5, 1);
		
		Ledsager l3 = new Ledsager("Mette");
		Booking_hotel bh1 = new Booking_hotel(null);
		Konference k1 = new Konference("Hav og Himmel", 1500, startdato, slutdato, tilmeldingsfrist);
		Deltager d1 = new Deltager("Finn Madsen", "00-00-00-00", "testvej 51", "testby", "testland", false);
		Booking_konference bk1 = new Booking_konference(startdato, slutdato, bh1, d1, k1);

		System.out.println("Forventet: 4500. \nAktuel: " + bk1.totalPris());

		System.out.println();
		
		Deltager d2 = new Deltager("Niels Petersen", "NielsP.-Tlf", "NielsP.-Adresse", "NielsP.-By", "NielsP.-land", false);
		Hotel h2 = new Hotel("Den Hvide Svane",0,1050);
		Booking_hotel bh2 = new Booking_hotel(h2);
		Konference k2 = new Konference("Hav og Himmel", 1500, startdato, slutdato, tilmeldingsfrist);
		Booking_konference bk2 = new Booking_konference(startdato, slutdato, bh2, d2, k2);
		System.out.println("Aktuelt: " + bk2.totalPris());
		System.out.println("Forventet: 6600");		
		
		System.out.println();
		
		Deltager d3 = new Deltager("Peter Sommer", "PeterS.-Tlf", "PeterS.-Adresse", "PeterS.-By", "PeterS.-land", false);
		Hotel h3 = new Hotel("Den Hvide Svane", 1250, 0);
		Serviceydelse sy1 = new Serviceydelse("Wifi",50);
		Booking_hotel bh3 = new Booking_hotel(h3);
		bh3.addServiceydelse(sy1);
		//ledsager + udflugter
		Ledsager l1 = new Ledsager("Mic Sommer");
		Udflugt u1 = new Udflugt("Egeskov", 75, startdato, false);
		Udflugt u2 = new Udflugt("Trapholt", 200, slutdato, true);
		l1.addUdflugt(u1);
		l1.addUdflugt(u2);
		//***************************
		d3.setLedsager(l1);
		Konference k3 = new Konference("Hav og Himmel", 1500, startdato, slutdato, tilmeldingsfrist);
		Booking_konference bk3 = new Booking_konference(startdato, slutdato, bh3, d3, k3);

		System.out.println("Forventet: 7375. \nAktuelt: " + bk3.totalPris());
		
		System.out.println();
		
		Deltager d4 = new Deltager("Lone Jensen", "LoneJ.-Tlf", "LoneJ.-address", "LoneJ.-By","LoneJ.-land",true);
		Hotel h4 = new Hotel("Den Hvide Svane",1250,0);
		Serviceydelse sy2 = new Serviceydelse("Wifi",50);
		Booking_hotel bh4 = new Booking_hotel(h4);
		bh4.addServiceydelse(sy2);
		//ledsager + udflugter
		Ledsager l2 = new Ledsager("Jan Madsen");
		Udflugt u3 = new Udflugt("Egeskov", 75, startdato, false);
		Udflugt u4 = new Udflugt("Byrundtur", 125, slutdato, true);
		l2.addUdflugt(u3);
		l2.addUdflugt(u4);
		//***************************
		d4.setLedsager(l2);
		Konference k4 = new Konference("Hav og Himmel", 1500, startdato, slutdato, tilmeldingsfrist);
		Booking_konference bk4 = new Booking_konference(startdato, slutdato, bh4, d4, k4);

		System.out.println("Forventet: 2800. \nAktuelt: " + bk4.totalPris());
		
	}

}
