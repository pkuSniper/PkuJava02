package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(432);
		stack.pop();
		stack.pop();
		stack.empty();
		System.out.print(stack.top()+ ""+stack.empty());
		

	}

}
class MyStack {
    // Push element x onto stack.
	private Queue queue1;
    public void push(int x) {
        Queue queue2 = new LinkedList();
        queue2.add(x);
        queue2.add(queue1);
        queue1 = queue2;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue1.remove();
        queue1 = (Queue)queue1.peek();
    }

    // Get the top element.
    public int top() {
		return (int) queue1.peek();
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
		return queue1 == null;
        
    }
}