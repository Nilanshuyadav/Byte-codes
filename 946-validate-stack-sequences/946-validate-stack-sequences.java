class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
       Stack<Integer> stack = new Stack();
        
        int n = pushed.length;
        int k=0;
        
        for(int i=0;i<n;i++){
            stack.push(pushed[i]);
            
            if(stack.peek() == popped[k]){
                while(stack.size()>0 && stack.peek() == popped[k]){
                    stack.pop();
                    k++;
                }    
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
}