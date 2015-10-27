package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution15 {
    public  List<List<Integer>> threeSum(int[] nums) {     
    	List<List<Integer>> list = new ArrayList<>();
    	if(nums.length < 3)
    		return list;
    	int count = 0;
    	Arrays.sort(nums);
    	while(count < nums.length - 2)
    	{
    	    int left = count + 1;
    		int right = nums.length - 1;
    		while(left < right && left < nums.length && right >= 0)
    		{

    			if(nums[count] + nums[left] + nums[right] < 0)
    			{
    				
    				left++;
    			}
    			else if(nums[count] + nums[left] + nums[right] > 0)
    			{
    				right--;
    			}
    			else if(nums[count] + nums[left] + nums[right] == 0)
        		{
        			list.add(Arrays.asList(nums[count],nums[left],nums[right]));
        			left++;
        			right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
        		}

    		}

            while (count <= nums.length - 3 && nums[count] == nums[count + 1])
        	{
    			count++;
        	}
    		count++;
    	}
    	
    	return list;
    }
	public static void main(String[] args) {
		
		int[] nums = {-1,0,1,2,-1,-4,5,-5};
		Solution15 solution = new Solution15();
		List<List<Integer>> resultList = new ArrayList<>();
		resultList = solution.threeSum(nums);
		int len = resultList.size();
		int count = 0;
		while(count < len)
		{
			System.out.print(resultList.get(count)+"\n");
			count++;
		}
		
	}
}

