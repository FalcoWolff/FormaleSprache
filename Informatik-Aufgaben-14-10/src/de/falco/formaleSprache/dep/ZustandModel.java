package de.falco.formaleSprache.dep;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ZustandModel {
	
	private Map<DataType,ZustandModel> future;
	
	public ZustandModel() {
		future = new LinkedHashMap<>();
	}
	
	public ZustandModel(DataPair pair1) {
		future = new LinkedHashMap<>();
		future.put(pair1.type, pair1.model);
	}
	
	public ZustandModel(DataPair pair1, DataPair pair2) {
		future = new LinkedHashMap<>();
		future.put(pair1.type, pair1.model);
		future.put(pair2.type, pair2.model);
	}
	
	public ZustandModel(DataPair pair1, DataPair pair2, DataPair pair3) {
		future = new LinkedHashMap<>();
		future.put(pair1.type, pair1.model);
		future.put(pair2.type, pair2.model);
		future.put(pair3.type, pair3.model);
	}
	
	public int anzahlAnFolgendenZustaenden(Object ob) {
		
		int counter = 0;
		
		for(DataType t : future.keySet()) {
			if(t.isData(ob)) {
				counter++;
			}
		}
		
		return counter;
		
	}
	
	public boolean kannZustandWechseln(Object ob) {
		
		for(DataType type : future.keySet()) {
			if(type.isData(ob)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public ZustandModel[] zustandWechseln(Object ob) {
		
		ZustandModel[] list = new ZustandModel[anzahlAnFolgendenZustaenden(ob)];
		
		int index = 0;
		
		for(DataType type : future.keySet()) {
			if(type.isData(ob)) {
				list[index] = future.get(type);
				index++;
			}
		}
		
		return list;
		
	}
	
	public boolean pruefeWort(String wort, int index) {
		
		char sign = wort.charAt(index);
		int nextindex = index++;
		
		boolean gefunden = false;
		
		
		if(nextindex == wort.length()) {
			return gefunden;
		}
		
		
		for(ZustandModel model : zustandWechseln(sign)) {
			
			if(model.isEndZustand() && nextindex+1 == wort.length()) {
				return true;
			}
			
			if(model.pruefeWort(wort, nextindex)) {
				gefunden = true;
			}
			
		}
		
		return gefunden;
		
	}
	
	public void print() {
		System.out.println("hu");
		future.values().stream().forEach((l) -> {l.print();});
	}
	
	public abstract boolean isEndZustand();
	
}
