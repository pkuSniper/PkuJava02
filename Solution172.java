package xiefeng;

public class Solution172 {
	 public int trailingZeroes(int n) {
		 //n!后缀0的个数 = n!质因子中5的个数 = floor(n/5) + floor(n/25) + floor(n/125) + ....
		  int  res=0;
	       while(n>0){
	           res=n/5+res;
	           n/=5;
	       }
	       return res;
	 }
}
