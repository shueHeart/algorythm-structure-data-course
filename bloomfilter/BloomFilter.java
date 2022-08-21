
public class BloomFilter {
	public int filter_len;

	public int bitArr;
	
	public int randNumForHash1 = 17;
	public int randNumForHash2 = 223;

	public BloomFilter(int f_len) {
		filter_len = f_len;
		bitArr = 0;
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
		
		int index1 = hash1(str1);
		int index2 = hash2(str1);
		
		int bits1 = (int) Math.pow(10, index1);
		int bits2 = (int) Math.pow(10, index2);
		
		if (existsChecker(index1)) bitArr += bits1;
		if (existsChecker(index2)) bitArr += bits2;
	}

	public boolean isValue(String str1) {
		
		int index1 = hash1(str1);
		int index2 = hash1(str1);
		
		return !existsChecker(index1) && !existsChecker(index2);
		
	}
	
	private boolean existsChecker(int index) {
		
		int arr = bitArr;
		
		for (int i = 0; i < index; ++i) {
			arr = arr / 10; 
		}
		int digit = arr % 10;
		return digit == 0;
	}
}
