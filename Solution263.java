package leetcode;

public class Solution263 {
	
    public static boolean isUgly(int num) {
    	if(num <= 0)
    		return false;
		while(num%2 == 0)
		{
			num/=2;
		}
		while(num%3 == 0)
		{
			num/=3;
		}
		while(num%5 == 0)
		{
			num/=5;
		}
		if(1 == num)   	
			return true; 
		
		return false;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		boolean bool = isUgly(i);
		System.out.println(bool);
		
	}

}
