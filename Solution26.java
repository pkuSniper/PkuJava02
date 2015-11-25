package xiefeng;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
        	return 0;
        }else{
        	int key=0;
            for(int i=1;i<nums.length;i++){
            	if(nums[i]!=nums[key]){
            		nums[key+1]=nums[i];
            		key++;
            	}
            }
        	return key+1;
        }
    }
}
