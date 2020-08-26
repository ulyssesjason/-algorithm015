class MinStack {
    
    private Stack<Integer> stack;
    private PriorityQueue<Integer> queue;
    
    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
        
    }
    
    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }
    
    public void pop() {
        int out = stack.pop();
        
        queue.remove(new Integer(out));
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return queue.peek(); 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
