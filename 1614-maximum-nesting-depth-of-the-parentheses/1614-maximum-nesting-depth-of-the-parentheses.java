class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        char ch;
        int max = 0;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(ch == '('){
                st.push('(');
                max = Math.max(max, st.size());
            }
            else if(ch == ')'){
                st.pop();
            }
        }
        
        return max;
    }
}