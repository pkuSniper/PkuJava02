public class Solution {
    public int lengthOfLastWord(String s) {
        int l=s.length();
        if(l==0)
            return 0;
        else
        {
            int i, n=0, flag=0;
            for(i=l-1; i>=0; i--)
            {
                if(s.charAt(i)==' '&&flag==0)
                    continue;
                else
                {
                    if(s.charAt(i)==' ')
                        break;
                    else
                        n++;
                    flag=1;
                }
            }
            return n;
        }
    }
}