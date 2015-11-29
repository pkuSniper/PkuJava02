package leetcode;

public class Solution171 {
	
    public int titleToNumber(String s) {
        int result = 0;
        int len = s.length();
        for(int cnt = 0;cnt < len;cnt++)
        {
        	result = result*26 + s.charAt(cnt) - 'A'+1;
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arg = "AAABBB";
		Solution171 solution = new Solution171();
		int result = solution.titleToNumber(arg);
		System.out.print(result);
		
	}

}
