class MyQueue {
    
    Stack<Integer> input_stack, output_stack;

    public MyQueue() {
        input_stack = new Stack<>();
        output_stack = new Stack<>();
    }
    
    public void push(int x) {
        input_stack.push(x);
    }
    
    public int pop() {
        int temp;
        if(!output_stack.isEmpty())
            temp = output_stack.pop();
        else{
            while(!input_stack.isEmpty()){
                output_stack.push(input_stack.pop());
            }
            
            temp = output_stack.pop();
        }
        
        return temp;
    }
    
    public int peek() {
        int temp;
        if(!output_stack.isEmpty())
            temp = output_stack.peek();
        else{
            while(!input_stack.isEmpty()){
                output_stack.push(input_stack.pop());
            }
            
            temp = output_stack.peek();
        }
        
        return temp;
    }
    
    public boolean empty() {
        return input_stack.isEmpty() && output_stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */