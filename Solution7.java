package xiefeng;

public class Solution7 {
	 public int reverse(int x) {
		 String str=x+"";
		 char[] ch=str.toCharArray();
		 char temp;
	     if(x<0){   
	    	 for(int i=1,j=str.length()-1;i<j;i++,j--){
	    		 temp=ch[i];
	    		 ch[i]=ch[j];
	    		 ch[j]=temp;
	    	 }
	    	 long result=Long.parseLong(String.valueOf(ch));
	    	 if(result<Integer.MIN_VALUE){
	    		 return 0;
	    	 }else{
	    		 return Integer.parseInt(String.valueOf(ch));
	    	 }
	     }else{
	    	 for(int i=0,j=str.length()-1;i<j;i++,j--){
	    		 temp=ch[i];
	    		 ch[i]=ch[j];
	    		 ch[j]=temp;
	    	 }
	    	 long result=Long.parseLong(String.valueOf(ch));
	    	 if(result>Integer.MAX_VALUE){
	    		 return 0;
	    	 }else{
	    		 return Integer.parseInt(String.valueOf(ch));
	    	 }
	     }
	 }
	 public static void main(String[] args) {
		Solution7 sol=new Solution7();
		//char[] c={'3','4'};
		//System.out.println(String.valueOf(c));
		System.out.println(sol.reverse(1534236469));
	}
}
