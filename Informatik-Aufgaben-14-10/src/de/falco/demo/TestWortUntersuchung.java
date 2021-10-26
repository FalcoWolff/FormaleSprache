package de.falco.demo;

import de.falco.formaleSprache.dep.Autokennzeichen;

public class TestWortUntersuchung {

	public static void main(String[] args) {
		
		Autokennzeichen kennzeichen = new Autokennzeichen();
		String wort1 = "1";
		String wort2 = "24";
		
		System.out.println(kennzeichen.wortUntersuchen(wort1));
		System.out.println(kennzeichen.wortUntersuchen(wort2));
		
		kennzeichen.print();
		
	}

}
