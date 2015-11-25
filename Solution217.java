package xiefeng;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        int[] newnums=sort(nums,0,nums.length-1);
        for(int i=0;i<newnums.length-1;i++){
        	if(newnums[i]==newnums[i+1]){
        		return true;
        	}
        }
    	return false;
    }
  //使用归并排序算法，先排序
  	 public int[] sort(int[] nums, int low, int high) {  
  	        int mid = (low + high) / 2;  
  	        if (low < high) {  
  	            // 左边  
  	            sort(nums, low, mid);  
  	            // 右边  
  	            sort(nums, mid + 1, high);  
  	            // 左右归并  
  	            merge(nums, low, mid, high);  
  	        }  
  	        return nums;  
  	    }  
  	  
  	    public void merge(int[] nums, int low, int mid, int high) {  
  	        int[] temp = new int[high - low + 1];  
  	        int i = low;// 左指针  
  	        int j = mid + 1;// 右指针  
  	        int k = 0;  
  	  
  	        // 把较小的数先移到新数组中  
  	        while (i <= mid && j <= high) {  
  	            if (nums[i] < nums[j]) {  
  	                temp[k++] = nums[i++];  
  	            } else {  
  	                temp[k++] = nums[j++];  
  	            }  
  	        }  
  	  
  	        // 把左边剩余的数移入数组  
  	        while (i <= mid) {  
  	            temp[k++] = nums[i++];  
  	        }  
  	  
  	        // 把右边边剩余的数移入数组  
  	        while (j <= high) {  
  	            temp[k++] = nums[j++];  
  	        }  
  	  
  	        // 把新数组中的数覆盖nums数组  
  	        for (int k2 = 0; k2 < temp.length; k2++) {  
  	            nums[k2 + low] = temp[k2];  
  	        }  
  	    }
}
