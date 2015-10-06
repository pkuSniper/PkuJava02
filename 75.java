public class Solution {
    public void sortColors(int[] nums) {
        int i=1, j=nums.length-1, temp;
        while(i<j)
        {
            while(nums[i]<=nums[0]&&i<j) i++;
            while(nums[j]>nums[0]&&i<j) j--;
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        temp=nums[0];
        nums[0]=nums[i];
        nums[i]=temp;
    }
}