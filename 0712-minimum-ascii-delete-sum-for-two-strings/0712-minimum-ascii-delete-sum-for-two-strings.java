class Solution {
    int[][] dp;
    int n, m;
    
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[1001][1001];
        n=s1.length();
        m=s2.length();
        
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return solve(s1, s2, 0, 0); 
    }
    
    public int solve(String s1, String s2, int i, int j){
        
        if(i>=n || j>=m){
            int cost = 0;
            
            for(int ind=i; ind<n; ind++)
                cost += s1.charAt(ind);
            
            for(int ind=j; ind<m; ind++)
                cost += s2.charAt(ind);
            
            return cost;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = solve(s1, s2, i+1, j+1);
        }
        
        return dp[i][j] = Math.min(s1.charAt(i) + solve(s1, s2, i+1, j), 
                                   Math.min(s2.charAt(j) + solve(s1, s2, i, j+1),                                                              s1.charAt(i)+s2.charAt(j)+solve(s1,s2,i+1,j+1)));
    }
}