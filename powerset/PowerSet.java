package powerset;

import java.util.*;

public class PowerSet {

	public List<String> storage;
	
	public PowerSet() {
		storage = new ArrayList<String>();
	}

	public int size() {
		// количество элементов в множестве
		return storage.size();
	}
	
	public void put(String value) {
		
		if (!storage.contains(value)) storage.add(value);
		// всегда срабатывает
	}

	public boolean get(String value) {
		// возвращает true если value имеется в множестве,
		// иначе false
		return storage.contains(value);
	}

	public boolean remove(String value) {
		// возвращает true если value удалено
		// иначе false
		
		return storage.remove(value);
	}

	public PowerSet intersection(PowerSet set2) {
		// пересечение текущего множества и set2
		PowerSet inter = new PowerSet();
		for (String string : storage) { 
			if (set2.get(string)) inter.put(string); 
		}
		
		return inter;
	}

	public PowerSet union(PowerSet set2) {
		// объединение текущего множества и set2
		
		PowerSet ps = new PowerSet();
		
		ps.storage.addAll(storage);
		ps.storage.addAll(set2.storage);
		
		return ps;
	}

	public PowerSet difference(PowerSet set2) {
		// разница текущего множества и set2
		
		PowerSet diff = new PowerSet();
		for (String string : storage) { 
			if (!set2.get(string)) diff.put(string); 
		}
		
		return diff;
	}

	public boolean isSubset(PowerSet set2) {
		// возвращает true, если set2 есть
		// подмножество текущего множества,
		// иначе false
		
		if (size() < set2.size()) return false;
		
		for (String str : set2.storage) {
			if (!get(str)) return false;
		}
		
		
		
		return true;
	}
}