package de.falco.formaleSprache.advanced;

import java.util.ArrayList;
import java.util.List;

public class FormaleSprache {
	
	private ZustandModel start;
	
	public FormaleSprache(ZustandModel start) {
		this.start = start;
	}
	
	public List<Terminal> findAlphabet() {
		
		return new ArrayList<>();
		
	}
	
	public boolean containsWord(String word) {
		
		if(start == null) {
			return false;
		}else {
			return start.containsWord(word, 0);
		}
		
	}
	
	

}
