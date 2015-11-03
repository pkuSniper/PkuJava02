package xiefeng;

import java.util.ArrayList;

public class Solution155 {
	 ArrayList<Integer> list=new ArrayList<Integer>();
	 int min;
	 public void push(int x) {
		    if(list.isEmpty()){
		    	min=x;
		    }else{
		    	if(min>x){
		    		min=x;
		    	}
		    }
	        list.add(x);
	    }

	    public void pop() {
	    	if(list.get(list.size()-1)==min){
	    	  int temp=list.get(0);
	    	  for(int i=1;i<list.size()-1;i++){
	    		  if(temp>list.get(i)){
	    			temp=list.get(i);
	    		  }
	    	  }
	    	  min=temp;
	    	}
	        list.remove(list.size()-1);
	    }

	    public int top() {
	        return list.get(list.size()-1);
	    }

	    public int getMin() {
	        return min;
	    }
}
