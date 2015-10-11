public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i, c;
        int[] ans = new int[2];
        Map map = new HashMap();
        for(i=0; i<nums.length; i++)
            map.put(nums[i], i);
        for(i=0; i<nums.length; i++)
        {
            c=target-nums[i];
            if(map.get(c)!=null&&(int)map.get(c)!=i)
            {
                c=(int)map.get(c);
                ans[0]=c+1;
                ans[1]=i+1;
                break;
            }
        }
        if(ans[0]>ans[1])
        {
            int temp=ans[0];
            ans[0]=ans[1];
            ans[1]=temp;
        }
        return ans;
    }
}