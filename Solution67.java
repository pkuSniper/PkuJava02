package leetcode;


public class Solution67 {
    public static String addBinary(String a, String b) {
    	int len1 = a.length()-1;
		int len2 = b.length()-1;
		String c = "";
		int len = 0;
		char flag1 = '0';
		char flag2 = '0';
		if(len1 > len2)
		{
			len = len1;
			int count1 = len1 - len2;
			while(count1 != 0)
			{
				b = '0' + b;
				count1--;
			}
		}
		if(len2 > len1 )
		{
			len = len2;
			int count2 = len2 - len1;
			while(count2 != 0)
			{
				a = '0' + a;
				count2--;
			}
		}
		if(len2 == len1)
		{
			len = len1;
		}
		while(len>=0)
		{		
				
				int index = a.charAt(len) + b.charAt(len) + flag2;
				switch(index)
				{
					case 144: // 0 0 0
						flag1 = '0';
						flag2 = '0';
						break;
					case 145: // 0 0 1
						flag1 = '1';
						flag2 = '0';
						break;
					case 146:// 0 1 1
						flag1 = '0';
						flag2 = '1';
						break;
					case 147:// 1 1 1
						flag1 = '1';
						flag2 = '1';
						break;
					default:
						break;
				}
				c = flag1 + c;
				len--;
		}
		if(flag2 == '1')
		{
			c = flag2 + c;
		}
    	
    	return c;
    	
        
    }

	public static void main(String[] args) {
		String a = "111111111111111111111111111111110010101010";
		String b = "101010101010101111111111110101";
		String c = "";
		c = addBinary(a, b);
		System.out.println(c);
		
	}

}

