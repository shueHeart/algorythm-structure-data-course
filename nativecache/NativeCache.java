package nativecache;


public class NativeCache<T> {
	public int size;
	public String[] slots;
	public T[] values;
	
	public int[] hits;
	
	public int step;

	public NativeCache(int sz, Class clazz, int st) {
		size = sz;
		slots = new String[size];
		hits = new int[size];
		step = st;
		values = (T[]) Array.newInstance(clazz, this.size);
	}

	public int hashFun(String key) {
		byte[] arr = key.getBytes();

		int sum = 0;

		for (int i = 0; i < arr.length; ++i) {
			sum += arr[i];
		}
		return sum % size;
	}

	public int seekSlot(String value) {

		int index = hashFun(value);

		if (slots[index] == null)
			return index;

		
		return collisionResolver(index, null);

	}

	public boolean isKey(String key) {
		int index = hashFun(key);

		if (key.equals(slots[index]))
			return true;

		
		return collisionResolver(index, key) != -1;
	}

	public void put(String key, T value) {

		if (isKey(key)) {
			int index = hashFun(key);
			if (key.equals(slots[index])) {
				values[index] = value;
				return;
			}

			int slot = collisionResolver(index, key);
			
			if (slot != -1) {
				values[slot] = value;
				return;
			}
		}

		int index = seekSlot(key);

		if (index == -1) {
			int freeIndexAfterCleaning = cleanFromUnnecessary();
			slots[freeIndexAfterCleaning] = key;
			values[freeIndexAfterCleaning] = value;			
			
			return;
		}

		slots[index] = key;
		values[index] = value;

	}

	public T get(String key) {

		int index = hashFun(key);
		if (key.equals(slots[index])) {
			hits[index] += 1;
			return values[index];
		}

		int elementIndex = collisionResolver(index, key);
		if (elementIndex != -1) {
			hits[elementIndex] += 1;
			return values[elementIndex];
		}
		return null;
	}
	
	private int collisionResolver (int startIndex, String key) {

		int collisionIndex = startIndex;

		if (collisionIndex + step >= size) {
			collisionIndex = collisionIndex + step - size;
		} else {
			collisionIndex += step;
		}
		
		while (collisionIndex != startIndex) {

			if ((key == null && slots[collisionIndex] == null) || (key != null && slots[collisionIndex] != null && slots[collisionIndex].equals(key))) {
				return collisionIndex;
			}

			if (collisionIndex + step >= size) {
				collisionIndex = collisionIndex + step - size;
				continue;
			}
			collisionIndex += step;
		}
		return -1;
	}
	
	private int cleanFromUnnecessary() {
		int appealsIndex = 0;
		for (int i : hits) {
			if (hits[i] < hits[appealsIndex]) appealsIndex = i;
		}
		slots[appealsIndex] = null;
		values[appealsIndex] = null;
				
		return appealsIndex;
	}

}
