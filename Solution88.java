package xiefeng;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp=new int[nums1.length];
        for(int p=0;p<temp.length;p++){
        	temp[p]=nums1[p];
        }
        int i=0;//temp计数
        int j=0;//nums2计数
        int k=0;//nums1计数
        while(i<m&&j<n){
        	if(temp[i]<nums2[j]){
        		nums1[k]=temp[i];
        		i++;
        		k++;
        	}else if(temp[i]>nums2[j]){
        		nums1[k]=nums2[j];
        		j++;
        		k++;
        	}else{
        		nums1[k]=temp[i];
        		i++;
        		k++;
        		nums1[k]=nums2[j];
        		j++;
        		k++;
        	}
        }
       while(i<m){
    	   nums1[k]=temp[i];
    	   i++;
    	   k++;
       }
       while(j<n){
    	   nums1[k]=nums2[j];
   		   j++;
   		   k++; 
       }
    }
    public static void main(String[] args) {
		Solution88 sol=new Solution88();
		int[] a={0};
		int[] b={1};
		sol.merge(a, 0, b, 1);
        System.out.println(a[0]);
	}
}
