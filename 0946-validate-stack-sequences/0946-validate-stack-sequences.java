class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        
        Stack<Integer> st = new Stack<>();
        int i=0, j=0;
        
        while(i<n && j<n){
            if(st.isEmpty()){
                st.push(pushed[i]);
                i++;
            }
            else if(st.peek() == popped[j]){
                st.pop();
                j++;
            }
            else{
                st.push(pushed[i]);
                i++;
            }
            
        }
        
        while(j<n){
            if(st.peek() == popped[j]){
                st.pop();
                j++;
            }
            else{
                break;
            }
        }
        
        return st.isEmpty();
    }
}