package opgaver;

import java.lang.reflect.Array;
import java.util.ArrayList;

import opgaver.Opgave01;
import opgaver.Customer;

public class TestApp {

	public static void main(String[] args) {
		Opgave01 s = new Opgave01();
		Opgave2_Array a1 = new Opgave2_Array();
		Opgave2_ArrayList a2 = new Opgave2_ArrayList();
		Customer c1 = new Customer("Test", "Test", 30);
		Customer c2 = new Customer("John", "Hoeeg", 29);
		Customer c3 = new Customer("Kristian", "Damsoe", 26);
		Customer c4 = new Customer("Magredte", "Laerer", 42);
		
		String[] stringBoubleSortering = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
				 "August", "Marius", "John", "Tove", "Poul", "Torkild"};
		
		s.bubbleSort(stringBoubleSortering);
		for (String liste : stringBoubleSortering) {
			System.out.print(liste + ", ");
		}
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - ");
	
		ArrayList<Customer> CustomerListArray = new ArrayList<>();
		CustomerListArray.add(c1);
		CustomerListArray.add(c2);
		CustomerListArray.add(c3);
		CustomerListArray.add(c4);
		
		a1.selectionSort(stringBoubleSortering);
		for (String selectionListe : stringBoubleSortering) {
			System.out.print(selectionListe + ", ");
		}
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - ");
		
		a2.selectionSort(CustomerListArray);
		for (Customer selectionArrayListe : CustomerListArray) {
			System.out.print(CustomerListArray + ", ");
		}
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - ");
	}
		

}
