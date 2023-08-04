class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] vis = new Boolean[n];
        
        return solve(0, n, s, new StringBuilder(""), new HashSet<>(wordDict), vis);    
    }
    
    public boolean solve(int ind, int n, String s, StringBuilder sb, Set<String> set, Boolean[] dp){
        if(ind == n){
            return true;
        }
        
        if(dp[ind] != null)  return dp[ind];
        
        char ch;
        
        for(int i=ind; i<n; i++){
            ch = s.charAt(i);
            
            sb.append(ch);
            if(set.contains(sb.toString()) && solve(i+1, n, s, new StringBuilder(""), set, dp))
                return true;
        }
        
        return dp[ind] = false;
    }
}