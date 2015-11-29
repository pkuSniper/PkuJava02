package leetcode;

public class Solution231 {

    public boolean isPowerOfTwo(int n) {
    	//要求判断n是否为2的幂，也就是1、2、4、8、16之类的。换成二进制也就是只有首位是1，其他位全部为0
    	//可以用n&(n-1)取与是否为0来判断。即10000&01111 == 0
    	if(n <= 0)
    		return false;
    	else
    		return ((n&(n-1))==0);     
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testNum = 32;
		Solution231 sol = new Solution231();
		System.out.println(sol.isPowerOfTwo(testNum));
		
	}

}
