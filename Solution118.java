package xiefeng;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
public List<List<Integer>> generate(int numRows) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();   
	 if(numRows==0){
		 return result;
	 }
	 for(int i=0; i<numRows; i++){  
         ArrayList<Integer> temp = new ArrayList<Integer>();  
         temp.add(1);  
         if(i>0){  
             for(int j=0; j<result.get(i-1).size()-1;j++){  
                 temp.add(result.get(i-1).get(j)+result.get(i-1).get(j+1));
             }
             temp.add(1);  
         }  
         result.add(temp);  
           
     }  
     return result;  
    }
public static void main(String[] args) {
	Solution118 sol=new Solution118();
	System.out.println(sol.generate(5));
}
}
