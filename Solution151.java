package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution151 {
	
    public static String reverseWords(String s) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		int count = 0;
		int map_len = 0;
		while(count <= s.length()-1)
		{
			String map_s = "";
			while(s.charAt(count) != ' ')
			{
				map_s += s.charAt(count);
				if(count == s.length()-1)
				{
					map.put(map_len, map_s);
					break;
				}
				count++;
			}
			if(map_s != "")
			{
				map.put(map_len, map_s);
				map_len++;
			}
	
			if(count == s.length()-1)
				break;
			while(s.charAt(count) == ' ')
			{
			//	System.out.println(count);
				if(count == s.length()-1)
					break;
				count++;
//				map.put(map_len, " " + s.charAt(count));
//				if(count == s.length()-1)
//					break;
//				count++;
//				map_len++;
			}
		}
		String newStr = "";
		int i = map_len-1;
		System.out.println(map_len);
		while(i >= 0)
		{
			System.out.println(i + "->"+map.get(i));
			if(i == map_len-1)
				{
					System.out.println(i + "->"+map.get(i));
					newStr+=map.get(i);
					System.out.println(i + "->"+newStr);
					i--;
					if(i < 0)
						break;
				}
			newStr = newStr + ' '+ map.get(i);
			System.out.println(i + "->"+newStr);
			i--;
		} 
		System.out.println(i + "->"+newStr);
    	return newStr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd  dsa das                 111 dsaff";
		String s1 = reverseWords(s);
		System.out.println(s1);
		

	}

}
