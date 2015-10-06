package leetcode;

import java.util.*;

public class Solution202 {
	
	public static boolean isHappy(int num) {
		
		int count = 0;
		int temp = num;
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		while(1 != num)
		{
			count = 0;
			while(true)
			{
				map1.put(count, num%10);
				num/=10;
				if(0 == num)
					break;
				count++;
			}
			int b =count;
			while(b >= 0)
			{
				num+=(map1.get(b)*map1.get(b));
				b--;
			}
			if(num == 20)
				return false;
		}
		return true;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Map<Integer, Integer> map1 = new HashMap();
//		Map<Integer, Integer> map2 = new HashMap();
//		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		int num = 20;
		System.out.println(isHappy(num));
	}

}
