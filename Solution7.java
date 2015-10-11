package leetcode;

public class Solution7 {
    public static int reverse(int num1) {
		long sum = 0;
		
		while(num1/10 >= 0 || num1/10 <= 0)
		{
			if(sum == 0)
				{
					sum+=num1%10;
					System.out.println(sum);
				}
			else
				{
					sum = sum*10 + num1%10;
					System.out.println(sum);
				}
			if(num1/10 == 0)
				break;
			num1/=10;
		}
		if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE )
			return 0;
		else
			return (int) sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num1 = 1534236469;
//		int sum = (int) reverse(num1);
//		System.out.println(sum);


	}

}
