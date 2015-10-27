package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 4)
        	return list;
        Arrays.sort(nums);
        int count = 0;
        while(count < nums.length - 3)
    	{
        	int count2 = count + 1;
        	while(count2 < nums.length - 2)
        	{
        		int left = count2 + 1;
        		int right = nums.length - 1;
        		while(left < right && left < nums.length && right >= 0)
        		{

        			if(nums[count] + nums[count2]+nums[left] + nums[right] < 0)
        			{
        				
        				left++;
        			}
        			else if(nums[count] + nums[count2] + nums[left] + nums[right] > 0)
        			{
        				right--;
        			}
        			else if(nums[count] + nums[count2] + nums[left] + nums[right] == 0)
            		{
            			list.add(Arrays.asList(nums[count],nums[count2],nums[left],nums[right]));
            			left++;
            			right--;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
            		}

        		}
                while (count2 <= nums.length - 3 && nums[count2] == nums[count2 + 1])
            	{
        			count2++;
            	}
        		count2++;
        		
        	}
    	    
            while (count <= nums.length - 4 && nums[count] == nums[count + 1])
        	{
    			count++;
        	}
    		count++;
    	}
        
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,-1,0,-2,2};
		int tar = 0;
		Solution18 solution = new Solution18();
		List<List<Integer>> resultList = new ArrayList<>();
		resultList = solution.fourSum(nums,tar);
		int len = resultList.size();
		int count = 0;
		while(count < len)
		{
			System.out.print(resultList.get(count)+"\n");
			count++;
		}
	}

}
