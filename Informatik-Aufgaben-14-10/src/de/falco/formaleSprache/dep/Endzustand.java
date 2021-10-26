package de.falco.formaleSprache.dep;

public class Endzustand extends ZustandModel{
	
	public Endzustand() {
		super();
	}
	
	public Endzustand(DataPair pair1) {
		super(pair1);
	}

	public Endzustand(DataPair pair1, DataPair pair2) {
		super(pair1, pair2);
	}
	
	public Endzustand(DataPair pair1, DataPair pair2, DataPair pair3) {
		super(pair1, pair2, pair3);
	}
	
	@Override
	public boolean isEndZustand() {
		return true;
	}

}
