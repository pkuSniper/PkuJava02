public class Solution {
    public void moveZeroes(int[] nums) {
        int l=nums.length, i=0;
        for(int j=0; j<l; j++)
            if(nums[j] != 0)
                nums[i++] = nums[j];
        for(int j=i; j<l; j++)
            nums[j] = 0;
    }
}