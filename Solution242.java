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
        // �ҳ��м�����  
        int center = (left + right) / 2;  
        // �����������еݹ�  
        sort(data, left, center);  
        // ���ұ�������еݹ�  
        sort(data, center + 1, right);  
        // �ϲ�  
        merge(data, left, center, right);  
    }  
   
    /** 
     * ������������й鲢���鲢ǰ��2�����������򣬹鲢����Ȼ���� 
     *  
     * @param data 
     *            ������� 
     * @param left 
     *            ������ĵ�һ��Ԫ�ص����� 
     * @param center 
     *            ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص����� 
     * @param right 
     *            ���������һ��Ԫ�ص����� 
     */ 
    /*
    public void merge(char[] data, int left, int center, int right) {  
        // ��ʱ����  
        char[] tmpArr = new char[data.length];  
        // �������һ��Ԫ������  
        int mid = center + 1;  
        // third ��¼��ʱ���������  
        int third = left;  
        // �����������һ��Ԫ�ص�����  
        int tmp = left;  
        while (left <= center && mid <= right) {  
            // ������������ȡ����С�ķ�����ʱ����  
            if (data[left] <= data[mid]) {  
                tmpArr[third++] = data[left++];  
            } else {  
                tmpArr[third++] = data[mid++];  
            }  
        }  
        // ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����  
        while (mid <= right) {  
            tmpArr[third++] = data[mid++];  
        }  
        while (left <= center) {  
            tmpArr[third++] = data[left++];  
        }  
        // ����ʱ�����е����ݿ�����ԭ������  
        // ��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩  
        while (tmp <= right) {  
            data[tmp] = tmpArr[tmp++];  
        }  
    } 
    */
}
