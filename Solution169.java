package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Solution169 {
    public static int majorityElement(int[] nums) {
    	int len = nums.length;
    	int needs = 0;
    	if(len % 2 == 0)
    		needs = len/2 +1;
    	else
    		needs = (len+1)/2;
    	HashMap<Integer,Integer> map = new HashMap<>();
    	int count = 0;
    	while(count < len)
    	{
    		int times = 0;
    		if(map.get(nums[count]) == null)
    		{
    			times = 1;
    		}
    		else
    		{
    			times = map.get(nums[count]) + 1;
    		}
    		map.put(nums[count], times);
    		count++;
    	}

    	Iterator it = map.keySet().iterator();
    	int key = 0;
    	while(it.hasNext())
    	{
    		key = (int) it.next();
    		int times = map.get(key);
    		System.out.println(key + " ´ÎÊý" + times);
    		if(times >= needs)
    			return key;
    	}
    	return key;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,34,3,44,3};
		int result = majorityElement(nums);
		System.out.print(result);

	}

}
