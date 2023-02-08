class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int ind=0; ind<n; ind++){
            if(s.charAt(ind)==')'){
                if(!st.isEmpty() && st.peek()=='(')
                    st.pop();
                else
                    return false;
            }
            else if(s.charAt(ind)=='}'){
                if(!st.isEmpty() && st.peek()=='{')
                    st.pop();
                else
                    return false;
            }
            else if(s.charAt(ind)==']'){
                if(!st.isEmpty() && st.peek()=='[')
                    st.pop();
                else
                    return false;
            }
            else{
                st.push(s.charAt(ind));
            }
        }
        
        return st.isEmpty();
    }
}