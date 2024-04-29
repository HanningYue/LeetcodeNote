class MyStack {
    Queue<Integer> queueOne;
    Queue<Integer> queueTwo;
    public MyStack() {
        queueOne = new LinkedList<>();
        queueTwo = new LinkedList<>();
    }
    
    public void push(int x) {
        while (!queueOne.isEmpty()) {
            queueTwo.offer(queueOne.poll());
        }
        queueOne.offer(x);
        while (!queueTwo.isEmpty()) {
            queueOne.offer(queueTwo.poll());
        }
    }
    
    public int pop() {
        return queueOne.poll();
    }
    
    public int top() {
        return queueOne.peek();
    }
    
    public boolean empty() {
        return queueOne.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */