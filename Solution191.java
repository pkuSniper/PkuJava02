package xiefeng;

public class SolutionBits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int num=0;
        while(n!=0){
        	num+=n&1;
        	n=n>>>1;
        }
        return num;
    }
}
