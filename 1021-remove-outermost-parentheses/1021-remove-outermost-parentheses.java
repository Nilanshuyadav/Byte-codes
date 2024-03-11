class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        int o=-1, n=s.length();
        char ch;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(ch == '('){
                o++;
                
                if(o>0){
                    sb.append(ch);
                }
            }
            else{
                o--;
                
                if(o>=0){
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
    }
}