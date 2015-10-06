package leetcode;

import java.util.ArrayList;
import java.util.List;



public class Solution119 {

    public  static List<Integer> getRow(int num) {
        List<Integer> list = new ArrayList<Integer>(); 
        if(0 == num)
        {
            list.add(1);
            return list;
        }
	    list.add(1);
	    int  k = num+1;
	    long s = 1;
	    for(int j =1;j <= k-2;j++)
	    {
		    list.add((int) (s=((k-j)*s/j)));
	    }
	    list.add(1);
	    return list;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>(); 
		int k =30;
		list = getRow(k);
        for(int i = 0; i < list.size(); i++)  
        {  
            System.out.print(list.get(i) + "\t");  
        }  
		//System.out.print("1\n");

	}

}
