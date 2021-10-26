package de.falco.formaleSprache.advanced;

import java.util.List;

public class Alphabet {
	
	private List<Terminal> terminal;
	
	
	public Alphabet(char...cs) {
		
		Terminal[] terminalArray = new Terminal[cs.length];
		
		for(int index = 0; index < cs.length; index++) {
			
			terminalArray[index] = new Terminal(cs[index]);
			
		}
		
		if(isMalformatted(terminalArray)) {
			
			throw new IllegalArgumentException("ein Terminal kommt mehrfach vor");
			
		}
		
		for(Terminal t : terminalArray) {
			terminal.add(t);
		}
		
	}
	
	public Alphabet(Terminal... terminalArray) {
		
		if(isMalformatted(terminalArray)) {
			
			throw new IllegalArgumentException("ein Terminal kommt mehrfach vor");
			
		}
		
		for(Terminal t : terminalArray) {
			terminal.add(t);
		}
		
	}
	
	public Terminal findTerminal(char s) {
		
		for(Terminal t : terminal) {
			
			if(t.isTerminal(s)) {
				return t;
			}
			
		}
		
		throw new IllegalArgumentException("couldnt find Terminal with '" + s + "'");
		
	}
	
	public Terminal createTerminal(char s) {
		
		if(!hasTerminal(s)) {
			Terminal t = new Terminal(s);
			terminal.add(t);
			
			return t;
		}
		
		throw new IllegalArgumentException("character '" + s + "' already is list");
		
	}
	
	public boolean hasTerminal(char s) {
		
		for(Terminal t : terminal) {
			
			if(t.isTerminal(s)) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public boolean hasTerminal(Terminal terminal) {
		
		for(Terminal t : this.terminal) {
			
			if(t.equals(terminal)) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	
	
	private boolean isMalformatted(Terminal[] t) {
		
		for(int index = 0; index < t.length; index++) {
			
			Terminal tmp = t[index];
			
			for(int value = index+1; value < t.length; value++) {
				
				Terminal tmp2 = t[value];
				
				if(tmp.equals(tmp2)) {
					
					return true;
					
				}
				
			}
			
			
		}
		
		return false;
		
	}

}
