class MinStack {
    private Stack<Integer> stack;
    private PriorityQueue<Integer> pq;
    public MinStack() {
        this.stack = new Stack<>();
        this.pq = new PriorityQueue<>();
    }
    
    public void push(int value) {
        stack.push(value);
        pq.add(value);
    }
    
    public void pop() {
        pq.remove(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */