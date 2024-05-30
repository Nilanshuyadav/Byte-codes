class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        int n = s.length();
        
        char ch;
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            ch = s.charAt(i);
            
            if(st.size()==0 || (st.size()==1 && ch==')')){}
            else{
                sb.append(ch);
            }
            
            if(ch==')' && st.peek()=='(') st.pop();
            else st.push(ch);
        }
        
        return sb.toString();
    }
}