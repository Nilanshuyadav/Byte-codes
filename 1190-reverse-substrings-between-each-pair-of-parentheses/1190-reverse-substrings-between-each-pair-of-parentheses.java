class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        int n = s.length();
        StringBuilder sb = new StringBuilder(""), ans = new StringBuilder("");
        char ch;
        int len, ind;
            
        for(int i=0; i<n; i++){
            ch = s.charAt(i);
            
            if(ch!='(' && st.isEmpty()){
                ans.append(ch);
            }
            else{
                if(ch==')'){
                    while(st.peek()!='('){
                        sb.append(st.pop());
                    }
                    
                    st.pop();
                    
                    if(st.isEmpty()){
                        ans.append(sb);
                    }
                    else{
                        ind=0;
                        len = sb.length();
                        
                        while(ind<len){
                            st.push(sb.charAt(ind++));
                        }
                    }
                    
                    sb.setLength(0);
                }
                else{
                    st.push(ch);
                }
            }
            
        }
        
        return ans.toString();
    }
}