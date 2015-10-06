package xiefeng;

public class Solution151 {
	/*
	  ±º‰∏¥‘”∂»£∫O(s1.length)
	 * */
	 public String reverseWords(String s) {
	        String[] s1=s.trim().split(" ");
	        String temp="";
	        for(int i=0,j=s1.length-1;i<j;i++,j--){
	        	temp=s1[i];
	        	s1[i]=s1[j];
	        	s1[j]=temp;
	        }
	        temp="";
	        for(int k=0;k<s1.length;k++){
	        	if(s1[k].length()!=0){
	        		temp+=s1[k]+" ";
	        	}
	        	
	        }
	        return temp.trim();
	 }
	 
	public static void main(String[] args) {
		String s="1   2 3";
		Solution151 sol=new Solution151();
		System.out.println(sol.reverseWords(s));
		
	}
}
