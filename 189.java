public class Solution {
    public void rotate(int[] nums, int k) {
        int l=nums.length;
        if(l!=0&&l!=1)
        {
            int m, i;
            m=k%l;
            int[] array=new int[l];
            if(m!=0)
            {
                for(i=m; i<l; i++)
                    array[i]=nums[i-m];
                for(i=0; i<m; i++)
                    array[i]=nums[i+l-m];
                for(i=0; i<l; i++)
                    nums[i]=array[i];
            }
        }
    }
}