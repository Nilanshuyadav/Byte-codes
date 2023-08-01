class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] dp = new Boolean[n];
        return solve(0, s, n, new HashSet<String>(wordDict), dp);
    }
    
    public boolean solve(int ind, String s, int n, Set<String> dict, Boolean[] dp){
        if(ind == n){
            return true;
        }
        
        if(dp[ind] != null) return dp[ind];
        
        StringBuilder sb = new StringBuilder("");
        char ch;
        
        boolean temp = false;
        for(int i=ind; i<n; i++){
            ch = s.charAt(i);
            
            sb.append(ch);
            
            if(dict.contains(sb.toString())){
                temp |= solve(i+1, s, n, dict, dp);
            }
            
            if(temp)  return dp[ind] = temp;
        }
        
        return dp[ind] = temp;
    }
}