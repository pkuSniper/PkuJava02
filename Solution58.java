package xiefeng;

public class Solution58 {
public int lengthOfLastWord(String s) {
        if(!s.contains(" ")){
        	return s.length();
        }
        if(s.trim().isEmpty()){
        	return 0;
        }
	    String[] sub=s.split(" ");
        if(sub[sub.length-1]==null){
        	return 0;
        }else{
        	return sub[sub.length-1].length();
        }
    }
}
