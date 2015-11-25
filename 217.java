public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int l = nums.length;
        if(l <= 1)
            return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<l; i++){
            if(map.get(nums[i]) != null)
                return true;
            map.put(nums[i], 1);
        }
        return false;
    }
}