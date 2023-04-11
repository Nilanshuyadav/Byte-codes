class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        
        int n = s.length();
        char ch;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(ch != '*'){
                st.add(ch);
            }
            else{
                st.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}