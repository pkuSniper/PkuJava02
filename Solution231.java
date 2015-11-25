package xiefeng;

public class Solution231 {
   public boolean isPowerOfTwo(int n) {
	    if(n==0){
	    	return false;
	    }
        while(true){
        	if(n%2==0){
        		n=n/2;
        	}else{
        		if(n==1){
        			return true;
        		}else{
        			return false;
        		}
        	}
        }
    }
}
