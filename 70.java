public class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else
        {
            int a=1, b=2, c=3;
            for(int i=3; i<=n; i++)
            {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}