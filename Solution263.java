package xiefeng;

import java.util.ArrayList;

public class Solution263 {
    public boolean isUgly(int num) {
    	/*int i=2;
    	if(num==1){
    		return true;
    	}
    	while(i<=(num/2)){
          if(num%i==0){
        	num=num/i;
        	if(i!=2&&i!=3&&i!=5){
        		return false;
        	}
          }else{
        	  i++;
          }
    	}
    	return true;
    	*/
    	 if(num==1) {
    		 return true;  
    	 }
         
         while(num>=2 && num%2==0){
        	 num/=2;  
         }
         while(num>=3 && num%3==0){
        	 num/=3;  
         }
         while(num>=5 && num%5==0){
        	 num/=5;  
         }
           
         return num==1;  
    }
    public static void main(String[] args) {
		Solution263 sol=new Solution263();
		if(sol.isUgly(1332185066)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
}
