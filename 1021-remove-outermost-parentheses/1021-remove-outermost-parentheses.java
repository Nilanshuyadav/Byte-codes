class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        int n = s.length();
        
        char ch;
        int cnt=0;
        
        for(int i=0; i<n; i++){
            ch = s.charAt(i);
            
            if(ch=='(') cnt++;
            else cnt--;
            
            if((ch=='(' && cnt!=1) || (ch==')' && cnt!=0)){
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}