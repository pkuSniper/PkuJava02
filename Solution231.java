package leetcode;

public class Solution231 {

    public boolean isPowerOfTwo(int n) {
    	//Ҫ���ж�n�Ƿ�Ϊ2���ݣ�Ҳ����1��2��4��8��16֮��ġ����ɶ�����Ҳ����ֻ����λ��1������λȫ��Ϊ0
    	//������n&(n-1)ȡ���Ƿ�Ϊ0���жϡ���10000&01111 == 0
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
