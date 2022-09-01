class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        dfs(0,new StringBuilder(""),ans,2*n);
        
        return ans;
    }
    
    public void dfs(int ind, StringBuilder sb, List<String> ans, int n){
        if(ind == n){
            if(toCheck(sb))
                ans.add(sb.toString());
            return;
        }
        
        sb.append('(');
        dfs(ind+1,sb,ans,n);
        
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        dfs(ind+1,sb,ans,n);
        
        sb.deleteCharAt(sb.length()-1);
    }
    
    public boolean toCheck(StringBuilder s){
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='(')
                stack.push('(');
            else if(stack.size()>0 && sb.charAt(i)==')' && stack.peek()=='(') stack.pop();
            else return false;
        }
        
        if(stack.size() == 0) return true;
        else return false;
    }
}