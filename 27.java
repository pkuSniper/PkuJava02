public class Solution {
    public int removeElement(int[] nums, int val) {
        int l1=nums.length;
        if(l1==0)
            return 0;
        else
        {
            int l=0, r=l1-1;
            while(l<=r)
            {
                while(l<=r&&nums[l]!=val) l++;
                if(l>r)
                    break;
                nums[l]=nums[r];
                r--;
            }
            return r+1;
        }
    }
}