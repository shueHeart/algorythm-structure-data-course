
public class BloomFilter {
	public int filter_len;

	public int bitArr;

	public int randNumForHash1 = 17;
	public int randNumForHash2 = 223;

	public BloomFilter(int f_len) {
		filter_len = f_len;
		bitArr = 0;
	}

	public int hash1(String str1) {

		int res = 0;
		for (int i = 0; i < str1.length(); i++) {
			int code = (int) str1.charAt(i);
			res *= randNumForHash1;
			res += code;
			res = res % filter_len;
		}
		return (int) Math.pow(2, res);
	}

	public int hash2(String str1) {
		int res = 0;
		for (int i = 0; i < str1.length(); i++) {
			int code = (int) str1.charAt(i);
			res *= randNumForHash2;
			res += code;
			res = res % filter_len;
		}
		
		return (int) Math.pow(2, res);
	}

	public void add(String str1) {

		int index1 = hash1(str1) ^ bitArr;
		int index2 = hash2(str1) ^ bitArr;
		
		int res1 = index1 ^ bitArr;
	
		if (res1 > bitArr) bitArr = bitArr | index1;
		
		int res2 = index2 ^ bitArr;

		if (res2 > bitArr) bitArr = bitArr | index2;
	}

	public boolean isValue(String str1) {

		int index1 = hash1(str1);
		int index2 = hash2(str1);
	
		return (index1 ^ bitArr) < bitArr && (index2 ^ bitArr) < bitArr;

	}

}
