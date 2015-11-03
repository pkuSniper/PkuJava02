package xiefeng;

import java.util.concurrent.ArrayBlockingQueue;

public class Solution225 {
	ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(20);
	// Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        int count=queue.size();
        while(count>1){
        	queue.add(queue.poll());
        	count--;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek(); 
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue.size()>0){
        	return false;
        }
        return true;
    }
}
