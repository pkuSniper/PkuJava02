public class Solution {
    public int addDigits(int num) {
        int c;
        while(num/10!=0)
        {
            c=0;
            while(num!=0)
            {
                c+=num%10;
                num/=10;
            }
            num=c;
        }
        return num;
    }
}