package leetcode;

import java.util.Arrays;

public class Solution242 {
	
    public boolean isAnagram(String s, String t) {
    	if(s=="" && t == "")
    		return true;
    	if(s.length()!=t.length())
    		return false;
    	if(s.length()==1)
    	{
    		if(s.charAt(0) == t.charAt(0))
    			return true;
    		else
    			return false;
    	}
    	char[] s1 = s.toCharArray();
    	char[] t1 = t.toCharArray();
	
    	Arrays.sort(s1);
    	Arrays.sort(t1);
    	
    	int cnt1 = s1.length-1;
    	int cnt2 = t1.length-1;
    	if(cnt1 == cnt2 && cnt1 ==-1)
    		return true;
    	
    	if(cnt1 != cnt2)
    		return false;
    	while(s1[cnt1] == t1[cnt2])
    	{
    		cnt1--;
    		cnt2--;
    		if(cnt1<0)
    			break;
    	}
    	if(cnt1==cnt2 && cnt1<=0)
    		return true;
    	else
    		return false;
    	

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution242 sol = new Solution242();
		String s1 = "a";
		String s2 = "b";
		System.out.println(sol.isAnagram(s1, s2));



	}

}
