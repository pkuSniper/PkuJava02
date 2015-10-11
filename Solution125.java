package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution125 {
    public static boolean isPalindrome(String str) {
    	String newStr = str.toLowerCase();
    	int len = newStr.length() - 1;
    	int count = 0;
    	if(str.length() == 1)
    		return true;
    	if(len < count)
    		return true;
		char front = newStr.charAt(count);
		char tail = newStr.charAt(len);
    	while(count <= len)
    	{
    		while(front <'0' || (front > '9' && front <'a') || front > 'z')
    		{
    			count++;
    			if(count == newStr.length())
    			{
    				count = newStr.length() + 1;
    				break;
    			}
    			front = newStr.charAt(count);	
    		}
    		if(count > newStr.length())
    			break;
    		while(tail <'0' || (tail > '9' && tail <'a') || tail > 'z')
    		{
    			len--;
    			tail = newStr.charAt(len); 	
    		}
    		if(front == tail)
    		{
    			count++;
    			len--;
    			if(len < 0 || count >= newStr.length())
    				break;
    			front = newStr.charAt(count);
    			tail = newStr.charAt(len); 	
    		}
    		else
    		{
    			return false;
    		}		
    	}
    	if(count > newStr.length())
    		return true;
    	
    	return true;
    	
//		Pattern p = Pattern.compile("[a-z0-9A-Z]");
//		Matcher m = p.matcher(str);
//		String s = "";
//		while(m.find())
//		{
//			s+=m.group();
//		}
//    	String newStr = s.toLowerCase();
//    	int len = s.length();
//    	int count = 0;
//    	while(count != len-1)
//    	{
//    		
//    	}
    	

//		String s2 = "";
//		StringBuffer s1 = new StringBuffer(s);
//		s2 = s1.reverse().toString();
//		String s4 = s.toLowerCase();
//		if(s4.equals(s2.toLowerCase()))
//			return true;
//		else
//			return false;
        
    }
    public static void main(String[] args) {
    	String s = ".a";
    	System.out.println(s.length());
    	System.out.println(isPalindrome(s));


		//String regEx = ".+/(.+)";
//		String regEx = "[A-Za-z0-9]";
//		String str = "c:/dir1/dir2/name.txtdsaewrew";
//		Pattern p = Pattern.compile(regEx);
//		Matcher m = p.matcher(str);
//		if (!m.find())
//		{
//		    System.out.println("文件路径格式错误!");
//		    return;
//		}
//		System.out.println(m.group(0));


//        String Regex="[A-Z0-9a-z]";
//        String TestStr="A man, a plan, a canal: Panama";
//        Pattern p=Pattern.compile(Regex);
//        Matcher matcher=p.matcher(TestStr);
//        System.out.println(matcher.group(0));
    	

//        if (matcher.find()) {
//            int gc=matcher.groupCount();
//            for (int i = 0; i <= gc; i++) {
//                System.out.println("group "+i+" :"+matcher.group(i));
//            }
//        }
    }

}
