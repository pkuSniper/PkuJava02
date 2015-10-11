package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Solution136 {
	
    public static int singleNumber(int[] nums) {
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i = 0; i <= nums.length - 1;i++)
    	{
    		if(map.get(nums[i]) != null)
    		{
        		if(map.get(nums[i]) >= 1)
        		{
        			int count = map.get(nums[i]) + 1;
        			map.put(nums[i], count);
        		}  			
    		}
    		if(map.get(nums[i]) == null)
    			map.put(nums[i], 1); 
    	}
    	Iterator iter = map.entrySet().iterator();
    	while(iter.hasNext())
    	{
    		Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>) iter.next();
    		if(entry.getValue() == 1)
    			return entry.getKey();
    	} 	
		return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,2,5,5,7,6,7,6,2,8};
		int i = singleNumber(nums);
		System.out.println(i);
		
	}

}
