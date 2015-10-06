public class Solution {
    public int myAtoi(String str) {
        if(str.isEmpty())
            return 0;
        str = str.trim();
        if(str.isEmpty())
            return 0;
        int flag=0, i, n=0;
        if(str.length()==1)
        {
            if(str.charAt(0)>='0'&&str.charAt(0)<='9')
                return str.charAt(0)-'0';
            else
                return 0;
        }
        else
        {
            if(str.charAt(0)=='+'||str.charAt(0)=='-')
            {
                if(str.charAt(0)=='+')
                    flag=1;
                else
                    flag=-1;
                if(str.charAt(1)>'9'||str.charAt(1)<'0')
                    return 0;
                for(i=1; i<str.length(); i++)
                {
                    if(str.charAt(i)<='9'&&str.charAt(i)>='0')
                    {
                        n = n*10+str.charAt(i)-'0';
                        if(n>=214748364&&i+1<str.length())
                        {
                            if(n==214748364)
                            {
                                if(flag==1&&str.charAt(i+1)>='8'&&str.charAt(i+1)<='9')
                                    return 2147483647;
                                if(flag==-1&&str.charAt(i+1)=='9')
                                    return -2147483648;
                            }
                            else if(str.charAt(i+1)>='0'&&str.charAt(i+1)<='9')
                            {
                                if(flag==1)
                                    return 2147483647;
                                else
                                    return -2147483648;
                            }
                        }
                    }
                    else
                        break;
                }
                if(flag==1)
                    return n;
                else
                    return -n;
            }
            else
            {
                if(str.charAt(0)>'9'||str.charAt(0)<'0')
                    return 0;
                for(i=0; i<str.length(); i++)
                {
                    if(str.charAt(i)<='9'&&str.charAt(i)>='0')
                    {
                        n = n*10+str.charAt(i)-'0';
                        if(n>=214748364&&i+1<str.length())
                        {
                            if(n==214748364)
                            {
                                if(str.charAt(i+1)>='8'&&str.charAt(i+1)<='9')
                                    return 2147483647;
                            }
                            else if(str.charAt(i+1)>='0'&&str.charAt(i+1)<='9')
                                return 2147483647;
                        }
                    }
                    else
                        break;
                }
                return n;
            }
        }
    }
}