package opgave03;

import javax.swing.JOptionPane;

public class E1_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog("What is your name?");
		String option = JOptionPane.showInputDialog("My name is Hal! What would you like me to do?");
		System.out.print("I'm sorry ");
		System.out.print(name);
		System.out.print(". I'm afraid I can't do that.");
		/*
		 * Dette er en kommando der har multiple input for at komme med en personalised besked.
		 * Der er baseret på filmen wargames.
		 */
	}

}
