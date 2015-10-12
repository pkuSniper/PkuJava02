package xiefeng;

public class Solution258 {
    public int addDigits(int num) {
        if(num>=0&&num<=9){
        	return num;
        }else{
            String strn;
        	while(num<0||num>9){
        		strn=num+"";
        		num=0;
            	for(int i=0;i<strn.length();i++){
            		num+=Integer.parseInt(String.valueOf(strn.charAt(i)));
            	}
            }
        	return num;
        }
    }
}
