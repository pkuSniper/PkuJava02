class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        if(min.empty() || x<=min.peek())
            min.push(x);
        stack.push(x);
    }

    public void pop() {
        if(!min.empty() && !stack.empty() && min.peek().equals(stack.peek()))
            min.pop();
        if(!stack.empty())
            stack.pop();
        else
            return;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}