package de.falco.formaleSprache.dep;

public class EditableZustand extends ZustandModel{
	
	public EditableZustand() {
		super();
	}
	
	public EditableZustand(DataPair pair1) {
		super(pair1);
	}

	public EditableZustand(DataPair pair1, DataPair pair2) {
		super(pair1, pair2);
	}
	
	public EditableZustand(DataPair pair1, DataPair pair2, DataPair pair3) {
		super(pair1, pair2, pair3);
	}
	
	@Override
	public boolean isEndZustand() {
		return false;
	}

}
