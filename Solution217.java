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
  //ʹ�ù鲢�����㷨��������
  	 public int[] sort(int[] nums, int low, int high) {  
  	        int mid = (low + high) / 2;  
  	        if (low < high) {  
  	            // ���  
  	            sort(nums, low, mid);  
  	            // �ұ�  
  	            sort(nums, mid + 1, high);  
  	            // ���ҹ鲢  
  	            merge(nums, low, mid, high);  
  	        }  
  	        return nums;  
  	    }  
  	  
  	    public void merge(int[] nums, int low, int mid, int high) {  
  	        int[] temp = new int[high - low + 1];  
  	        int i = low;// ��ָ��  
  	        int j = mid + 1;// ��ָ��  
  	        int k = 0;  
  	  
  	        // �ѽ�С�������Ƶ���������  
  	        while (i <= mid && j <= high) {  
  	            if (nums[i] < nums[j]) {  
  	                temp[k++] = nums[i++];  
  	            } else {  
  	                temp[k++] = nums[j++];  
  	            }  
  	        }  
  	  
  	        // �����ʣ�������������  
  	        while (i <= mid) {  
  	            temp[k++] = nums[i++];  
  	        }  
  	  
  	        // ���ұ߱�ʣ�������������  
  	        while (j <= high) {  
  	            temp[k++] = nums[j++];  
  	        }  
  	  
  	        // ���������е�������nums����  
  	        for (int k2 = 0; k2 < temp.length; k2++) {  
  	            nums[k2 + low] = temp[k2];  
  	        }  
  	    }
}
