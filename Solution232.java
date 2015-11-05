package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution232 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue que = new MyQueue();
		que.push(222);
		que.push(2);
		que.push(3);
		que.push(2);
		que.push(666);
		
		
		System.out.print(que.peek());

	}

}
class MyQueue {
	List<Integer> list1 = new ArrayList<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
    	list1.add(x);
        
    }

    // Removes the element from in front of queue.
    public void pop() {
    	List<Integer> list2 = new ArrayList<Integer>();
    	while(!list1.isEmpty())
    	{
    		list2.add(list1.get(list1.size()-1));
    		list1.remove(list1.size()-1);
    	}
    	list2.remove(list2.size()-1);
    	while(!list2.isEmpty())
    	{
    		list1.add(list2.get(list2.size()-1));
    		list2.remove(list2.size()-1);
    	}
        
    }

    // Get the front element.
    public int peek() {
    	List<Integer> list2 = new ArrayList<Integer>();
    	while(!list1.isEmpty())
    	{
    		list2.add(list1.get(list1.size()-1));
    		list1.remove(list1.size()-1);
    	}
    	int top = list2.get(list2.size()-1);
    	while(!list2.isEmpty())
    	{
    		list1.add(list2.get(list2.size()-1));
    		list2.remove(list2.size()-1);
    	}
		return top;
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
		return list1.isEmpty();
        
    }
}