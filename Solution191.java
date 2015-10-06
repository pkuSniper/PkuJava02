package leetcode;

public class Solution191 {
    // you need to treat n as an unsigned value
//    public  int hammingWeight(int n) {
//    	int num = 0;
//    //首先对n进行%取余运算，余数为1便num++，对n =/2取商运算,依次循环
//    	while(n/2 >= 0)
//    	{
//    		if(1 == n%2)
//    		{
//    			num++;
//    		}
//    		if(0 == n)
//    		{
//    			return num;
//    		}
//    		n/=2;
//    	}
//    	return num;   
//    }
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (1 == (n&1)) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int n = 2147483648;
		int n = 11;
		Solution191 a = new Solution191();
		System.out.println(a.hammingWeight(n));

	}



}





	




