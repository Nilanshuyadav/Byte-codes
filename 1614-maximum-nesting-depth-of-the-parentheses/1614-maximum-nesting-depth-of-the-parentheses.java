class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        
        Stack<Character> st = new Stack<>();
        
        char ch;
        int cnt=0;
        
        for(int i=0; i<n; i++){
            ch = s.charAt(i);
            
            if(ch==')' && st.peek()=='('){
                st.pop();
            }
            else if(ch=='('){
                st.push(ch);
            }
            
            cnt = Math.max(cnt, st.size());
        }
        
        return cnt;
    }
}