package de.falco.formaleSprache.advanced;

public class Terminal {
	
	private char sign;
	
	public Terminal(char sign) {
		this.sign = sign;
	}
	
	public boolean isTerminal(char sign) {
		return this.sign == sign;
	}
	
	public char getSign() {
		return sign;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terminal other = (Terminal) obj;
		if (sign != other.sign)
			return false;
		return true;
	}
	
	

}
