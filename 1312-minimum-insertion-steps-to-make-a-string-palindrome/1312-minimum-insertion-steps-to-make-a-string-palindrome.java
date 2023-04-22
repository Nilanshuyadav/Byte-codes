class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        return n-(lcs(s, new StringBuilder(s).reverse().toString()));
    }
    
    public int lcs(String s1, String s2){
        int n = s1.length(), m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
    
    public int helper(int ind1, int ind2, String s1, String s2, int[][] dp){
        if(ind1<0 || ind2<0)
            return 0;
        
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = 1+helper(ind1-1, ind2-1, s1, s2, dp);
        }
        
        return dp[ind1][ind2] = Math.max(helper(ind1-1, ind2, s1, s2, dp), helper(ind1, ind2-1, s1, s2, dp));
    }
}