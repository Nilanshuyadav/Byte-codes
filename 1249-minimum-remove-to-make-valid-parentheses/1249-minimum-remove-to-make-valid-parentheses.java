class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder st = new StringBuilder();
        int n = s.length();
        int open=0;
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            
            if(Character.isLetter(ch)) st.append(ch);
            else if(ch == '(') {st.append(ch); open++;}
            else{
                if(open == 0) continue;
                else{
                    st.append(ch);
                    open--;
                }
            }
        }
        
        if(open != 0){
            n = st.length()-1;
            StringBuilder ans = new StringBuilder();
            while(n>=0){
                char ch = st.charAt(n);
                if(ch=='(' && open != 0) open--;
                else ans.append(ch);
                n--;
            }
            
            return ans.reverse().toString();
        }
        
        return st.toString();
    }
}