
public class BloomFilter {
	public int filter_len;

	public int[] bitArr;
	
	public int randNumForHash1 = 17;
	public int randNumForHash2 = 223;

	public BloomFilter(int f_len) {
		filter_len = f_len;
		for (int i = 0; i < f_len; ++i) {
			bitArr[i] = 0;
		}
	}

	public int hash1(String str1)
      {

    	int res = 0; 
        for(int i=0; i < str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            
            res += code;
            res *= randNumForHash1;
        }

        return res % filter_len;
      }

	public int hash2(String str1) {
    	int res = 0; 
        for(int i=0; i < str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            
            res += code;
            res *= randNumForHash2;
        }

        return res % filter_len;	
	}

	public void add(String str1) {
		int valHash1 = hash1(str1);
		int valHash2 = hash1(str1);
		
		bitArr[valHash1] = 1;
		bitArr[valHash2] = 1;
		
	}

	public boolean isValue(String str1) {
		
		int valHash1 = hash1(str1);
		int valHash2 = hash1(str1);
		
		if (bitArr[valHash1] == 1 && bitArr[valHash2] == 1) return true;

		return false;
	}
}
