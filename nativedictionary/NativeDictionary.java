
import java.lang.reflect.Array;

public class NativeDictionary<T> {
	public int size;
	public String[] slots;
	public T[] values;
	public int step = 3;

	public NativeDictionary(int sz, Class clazz) {
		size = sz;
		slots = new String[size];
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

		int collisionIndex = index;

		if (collisionIndex + step >= size) {
			collisionIndex = collisionIndex + step - size;
		} else {
			collisionIndex += step;
		}

		while (collisionIndex != index) {

			if (slots[collisionIndex] == null) {
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

	public boolean isKey(String key) {
		int index = hashFun(key);
		
		if (key.equals(slots[index])) return true;
			
		int collisionIndex = index;

		if (collisionIndex + step >= size) {
			collisionIndex = collisionIndex + step - size;
		} else {
			collisionIndex += step;
		}

		while (collisionIndex != index) {

			if (key.equals(slots[collisionIndex])) {
				return true;
			}

			if (collisionIndex + step >= size) {
				collisionIndex = collisionIndex + step - size;
				continue;
			}
			collisionIndex += step;
		}
			
		return false;
	}

	public void put(String key, T value) {
		
		if (isKey(key)) {
			int index = hashFun(key);
			if (key.equals(slots[index])) {
				values[index] = value;
				return;
			}
			
			int collisionIndex = index;

			if (collisionIndex + step >= size) {
				collisionIndex = collisionIndex + step - size;
			} else {
				collisionIndex += step;
			}

			while (collisionIndex != index) {

				if (key.equals(slots[collisionIndex])) {
					values[collisionIndex] = value;
					return;
				}

				if (collisionIndex + step >= size) {
					collisionIndex = collisionIndex + step - size;
					continue;
				}
				collisionIndex += step;
			}
		}
		
		int index = seekSlot(key);
		if (index == -1) return;
		slots[index] = key;
		values[index] = value;
		
		
	}

	public T get(String key) {
				
		int index = hashFun(key);
		
		if (key.equals(slots[index])) return values[index];
		
		
		int collisionIndex = index;

		if (collisionIndex + step >= size) {
			collisionIndex = collisionIndex + step - size;
		} else {
			collisionIndex += step;
		}

		while (collisionIndex != index) {

			if (key.equals(slots[collisionIndex])) {
				return values[collisionIndex];
			}

			if (collisionIndex + step >= size) {
				collisionIndex = collisionIndex + step - size;
				continue;
			}
			collisionIndex += step;
		}
		
		
		return null;
	}
}
