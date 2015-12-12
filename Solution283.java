package xiefeng;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int first1=0;
        int first2;
        while(first1<nums.length){
        	first2=first1+1;
        	if(nums[first1]!=0){
        		first1++;
        	}else{
        		while(first2<nums.length&&nums[first2]==0){
        			first2++;
        		}
        		if(first2==nums.length){
        			break;
        		}else{
        			nums[first1]=nums[first2];
            		nums[first2]=0;
        		}
        	}
        }
    }
    public static void main(String[] args) {
    	Solution283 sol=new Solution283();
    	int[] nums={1,0,3,0,12};
		sol.moveZeroes(nums);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+"   ");
		}
	}
}
