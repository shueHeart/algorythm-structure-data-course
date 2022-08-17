public class PowerSet {

	public List<String> storage;
	
	public PowerSet() {
		storage = new ArrayList<String>();
	}

	public int size() {
		return storage.size();
	}
	
	public void put(String value) {
		if (!storage.contains(value)) storage.add(value);
	}

	public boolean get(String value) {
		return storage.contains(value);
	}

	public boolean remove(String value) {		
		return storage.remove(value);
	}

	public PowerSet intersection(PowerSet set2) {
		PowerSet inter = new PowerSet();
		for (String string : storage) { 
			if (set2.get(string)) inter.put(string); 
		}
		
		return inter;
	}

	public PowerSet union(PowerSet set2) {
		
		PowerSet ps = new PowerSet();
		
		
		for (String str : storage) {
			ps.put(str);
		}
		
		for (String str : set2.storage) {
			ps.put(str);
		}
		
		return ps;
	}

	public PowerSet difference(PowerSet set2) {
		
		PowerSet diff = new PowerSet();
		for (String string : storage) { 
			if (!set2.get(string)) diff.put(string); 
		}
		
		return diff;
	}

	public boolean isSubset(PowerSet set2) {
		
		if (size() < set2.size()) return false;
		
		for (String str : set2.storage) {
			if (!get(str)) return false;
		}
		
		return true;
	}
}
