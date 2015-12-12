package xiefeng;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
    	/*
       for(int i=0;i<s.length();i++){
    	   if(s.charAt(i)>'z'&&s.charAt(i)<'a'){
    		   if(!s.equals("")){
    			   return false; 
    		   }
    	   }
       }
       for(int i=0;i<t.length();i++){
    	   if(t.charAt(i)>'z'&&t.charAt(i)<'a'){
    		   if(!t.equals("")){
    			   return false; 
    		   }
    	   }
       }
       */
       char[] c1=s.toCharArray();
       char[] c2=t.toCharArray();
       /*
       sort(c1,0,c1.length-1);
       sort(c2,0,c2.length-1);
       s=new String(c1);
       t=new String(c2);
       if(s.equals(t)){
    	  return true; 
       }else{
    	   return false; 
       }
       */
       int[] count1=new int[26];
       int[] count2=new int[26];
       for(int i=0;i<26;i++){
    	   count1[i]=0;
       }
       for(int i=0;i<26;i++){
    	   count2[i]=0;
       }
       for(int i=0;i<c1.length;i++){
    	   count1[c1[i]-'a']++;
       }
       for(int i=0;i<c2.length;i++){
    	   count2[c2[i]-'a']++;
       }
       for(int j=0;j<26;j++){
    	   if(count1[j]!=count2[j]){
    		   return false;
    	   }
       }
       return true;
    }
    /*
    public void sort(char[] data, int left, int right) {  
        if (left >= right)  
            return;  
        // 找出中间索引  
        int center = (left + right) / 2;  
        // 对左边数组进行递归  
        sort(data, left, center);  
        // 对右边数组进行递归  
        sort(data, center + 1, right);  
        // 合并  
        merge(data, left, center, right);  
    }  
   
    /** 
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序 
     *  
     * @param data 
     *            数组对象 
     * @param left 
     *            左数组的第一个元素的索引 
     * @param center 
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引 
     * @param right 
     *            右数组最后一个元素的索引 
     */ 
    /*
    public void merge(char[] data, int left, int center, int right) {  
        // 临时数组  
        char[] tmpArr = new char[data.length];  
        // 右数组第一个元素索引  
        int mid = center + 1;  
        // third 记录临时数组的索引  
        int third = left;  
        // 缓存左数组第一个元素的索引  
        int tmp = left;  
        while (left <= center && mid <= right) {  
            // 从两个数组中取出最小的放入临时数组  
            if (data[left] <= data[mid]) {  
                tmpArr[third++] = data[left++];  
            } else {  
                tmpArr[third++] = data[mid++];  
            }  
        }  
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）  
        while (mid <= right) {  
            tmpArr[third++] = data[mid++];  
        }  
        while (left <= center) {  
            tmpArr[third++] = data[left++];  
        }  
        // 将临时数组中的内容拷贝回原数组中  
        // （原left-right范围的内容被复制回原数组）  
        while (tmp <= right) {  
            data[tmp] = tmpArr[tmp++];  
        }  
    } 
    */
}
