class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int ind = 2;ind<=n;ind++){
            int sum = 0;
            for(int curr = 1;curr<=ind;curr++)
                sum += dp[curr-1]*dp[ind-curr];
            dp[ind] = sum;
        }
        
        return dp[n];
    }
    
}