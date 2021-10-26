package de.falco.formaleSprache.dep;

public class Autokennzeichen {
	
	private ZustandModel start;
	
	public Autokennzeichen() {
		buildTree();
	}
	
	public void buildTree() {
		
		Ziffer ziffer = new Ziffer();
		Buchstabe b = new Buchstabe();
		
		Endzustand z13 = new Endzustand();
		Endzustand z12 = new Endzustand(new DataPair(ziffer, z13));
		Endzustand z11 = new Endzustand(new DataPair(ziffer, z12));
		Endzustand z10 = new Endzustand(new DataPair(ziffer, z11));
		EditableZustand z8 = new EditableZustand(new DataPair(ziffer, z10));
		
		start = z8;
		
	}
	
	public void print() {
		start.print();
	}
	
	public boolean wortUntersuchen(String wort) {
		
		return start.pruefeWort(wort, 0);
		
	}

}
