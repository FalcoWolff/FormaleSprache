package de.falco.formaleSprache.dep;

public class Buchstabe extends DataType{
	
	public static final char[] buchstaben = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß'};

	@Override
	public boolean isData(Object ob) {
		
		try {
			char origin = (char) ob;
			for(char c : buchstaben) {
				if(origin == c) {
					return true;
				}
			}
		}catch(Exception e) {
			
		}
		
		return false;
	}
	
	
	
}	
