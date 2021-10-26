package de.falco.formaleSprache.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class ZustandModel {
	
	private Map<ZustandModel, List<Terminal>> future = new LinkedHashMap<>();
	
	public abstract boolean isEndZustand();
	
	
	public boolean containsWord(String text, int index) {
		
		if(text.length() >= index) {
			
			return isEndZustand();
			
		}
		
		char c = text.charAt(index);
		
		ArrayList<ZustandModel> models = findZustandModels(c);
		
		for(ZustandModel z : models) {
			if(z.containsWord(text, index+1)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	private ArrayList<ZustandModel> findZustandModels(char c) {
		
		ArrayList<ZustandModel> list = new ArrayList<>();
		
		for(ZustandModel m : future.keySet()) {
			
			for(Terminal t : future.get(m)) {
				if(t.isTerminal(c)) {
					list.add(m);
				}
			}
		}
		
		return list;
		
	}
	
	public void updateFutureZustand(ZustandModel model, Terminal...terminals) {
		
		List<Terminal> newTerminalList = Arrays.asList(terminals);
		
		if(!hasFutureZustand(model)) {
			
			future.put(model, newTerminalList);
			
		}else {
			
			List<Terminal> l = sucheVereinigungsMenge(newTerminalList, future.get(model));
			
			for(Terminal tmp : l) {
				if(!future.get(model).contains(tmp)) {
					future.get(model).add(tmp);
				}
			}
			
		}
		
	}
	
	private List<Terminal> sucheVereinigungsMenge(List<Terminal> list1, List<Terminal> list2) {
		
		List<Terminal> list = new ArrayList<>();
		
		for(Terminal terminal : list1) {
			if(!list2.contains(terminal)) {
				list.add(terminal);
			}
		}
		
		return list;
		
	}
	
	public boolean hasFutureZustand(ZustandModel model) {
		
		return future.keySet().contains(model);
		
	}
	
}
