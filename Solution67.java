package xiefeng;

public class Solution67 {
	 /*
	  ʱ�临�Ӷȣ�O(max(a.length(),b.lengh()))
	  * */
	 public String addBinary(String a, String b) {
		    String c="";
		    int carry=0;//��λ
		    int i,j;
		    /*
		             ��������ͬ���ּ��� 
		     */
	        for(i=(a.length()-1),j=(b.length()-1);i>=0&&j>=0;i--,j--){
	        	if(a.charAt(i)=='1'&&b.charAt(j)=='1'){
	        		if(carry==1){
	        			c="1"+c;
	        		}else{
	        			c="0"+c;
		        		carry=1;
	        		}
	        		
	        	}else if(a.charAt(i)=='1'||b.charAt(j)=='1'){
	        		if(carry==1){
	        			c="0"+c;
	        		}else{
	        			c="1"+c;
	        		}
	        	}else{
	        		if(carry==1){
	        			c="1"+c;
	        			carry=0;
	        		}else{
	        			c="0"+c;
	        		}
	        	}
	        }
	        
	        /*
            �����������ּ��� 
    */
	        if(a.length()>b.length()){
	        	if(carry==1){
	        		while(a.charAt(i)=='1'){
	        			c="0"+c;
	        			i--;//��������
	        			if(i<0){
	        				break;
	        			}
	        		}
	        		c="1"+c;
	        		i--;
	        		while(i>=0){
	        			c=a.charAt(i)+""+c;
	        			i--;
	        		}
	        	}else{
	        		while(i>=0){
	        			c=a.charAt(i)+""+c;
	        			i--;
	        		}
	        	}
	        }else if(a.length()<b.length()){
	        	if(carry==1){
	        		while(b.charAt(j)=='1'){
	        			c="0"+c;
	        			j--;//��������
	        			if(j<0){
	        				break;
	        			}
	        		}
	        		c="1"+c;
	        		j--;
	        		while(j>=0){
	        			c=b.charAt(j)+""+c;
	        			j--;
	        		}
	        	}else{
	        		while(j>=0){
	        			c=b.charAt(j)+""+c;
	        			j--;
	        		}
	        	}
	        }else{
	        	if(carry==1){
	        		c="1"+c;
	        	}
	        }
	        return c;
	    }
	 public static void main(String[] args) {
		String s1="0";
		String s2="0";
		Solution67 sol=new Solution67();
		String s=sol.addBinary(s1, s2);
		System.out.println(s);
	}
}
