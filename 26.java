public class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=1, l=nums.length;
        if(l == 0)
            return 0;
        if(l == 1)
            return 1;
        int t, last = nums[0];
        while(j < l){
            while(j<l && last==nums[j]) j++;
            if(j >= l)
                break;
            i++;
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            j++;
            last = nums[i];
        }
        return i+1;
    }
}