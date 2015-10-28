package xiefeng;

import java.util.ArrayList;
import java.util.List;

public class Solution15 {
	 public List<List<Integer>> threeSum(int[] nums) {
		    List<List<Integer>> momlist=new ArrayList<List<Integer>>();
		    int[] newnums=sort(nums,0,nums.length-1);
		    for(int i=0;i<newnums.length-1;i++){
		    	int j=i+1;//取i+1避免重复计算，因为选定的中心元素就是从右向左的
		    	int k=newnums.length-1;
		    	while(j<k){
		    		if((newnums[j]+newnums[k])<(-newnums[i])){
		    			j++;
		    		}else if((newnums[j]+newnums[k])>(-newnums[i])){
		    			k--;
		    		}else if((newnums[j]+newnums[k])==(-newnums[i])){
				    		List<Integer> sonlist=new ArrayList<Integer>();
		    				sonlist.add(newnums[i]);
		    				sonlist.add(newnums[j]);
		    				sonlist.add(newnums[k]);
		    				momlist.add(sonlist);
		    				j++;
		    				k--;
	    	        		while(j<k&&newnums[j]==newnums[j-1]){
	    	        					j++;
	    	        		}
	    	        		while(k>j&&newnums[k]==newnums[k+1]){
	    	        					k--;
	    	        		}
		    		  }
		    	}
		    	if(i<(newnums.length-1)){	
				    while(newnums[i+1]==newnums[i]){
				    	i++;
				    	if(i>=(newnums.length-1)){
				    		break;
				    	}
				    }
				    }
		  }
		    			
		    return momlist;
}
		    /*
	        for(int i=0;i<nums.length;i++){
	        	for(int j=0;j<nums.length;j++){
	        		for(int k=0;k<nums.length;k++){
	        			if(i+j+k==0){
	        				if(momlist.size()==0){
	        					List<Integer> sonlist=new ArrayList<Integer>();
    	        				sonlist.add(i);
    	        				sonlist.add(j);
    	        				sonlist.add(k);
    	        				momlist.add(sonlist);
	        				}
	        				for(int m=0;m<momlist.size();m++){
	        					if(momlist.get(m).contains(i)&&momlist.get(m).contains(j)&&momlist.get(m).contains(k)){
	        						break;
	        					}else{
	        						List<Integer> sonlist=new ArrayList<Integer>();
	    	        				sonlist.add(i);
	    	        				sonlist.add(j);
	    	        				sonlist.add(k);
	    	        				momlist.add(sonlist);
	        					}
	        				}
	        				
	        			}
	        		}
	        	}
	        }
	        */
	     
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
	    
	    public static void main(String[] args) {
			Solution15 sol=new Solution15();
			int[] nums={1,-1};
			sol.threeSum(nums);
		}
}
