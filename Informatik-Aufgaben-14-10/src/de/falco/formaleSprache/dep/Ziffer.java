package de.falco.formaleSprache.dep;

public class Ziffer extends DataType{
	
	public static final Integer[] ziffern = {1,2,3,4,5,6,7,8,9,0};

	@Override
	public boolean isData(Object ob) {
		
		try {
			
			int ziffer = -1;
			
			if(ob instanceof Character) {
				
				char c = (char) ob;
				ziffer = Character.getNumericValue(c);
				
			}else if(ob instanceof Integer) {
				
				ziffer = (int) ob;
				
			}
			
			if(ziffer >= 0 && ziffer <= 9) {
				return true;
			}else {
				return false;
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
		
	}

}
