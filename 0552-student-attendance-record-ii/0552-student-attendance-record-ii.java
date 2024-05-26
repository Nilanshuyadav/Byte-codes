class Solution {
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j, -1);
            }
        }
        
        return (int)helper(n, 1, 2, dp);
    }
    
    public long helper(int ind, int A, int L, int[][][] dp){
        if(ind==0){
            return 1;
        }
        
        if(dp[ind][A][L] != -1)
            return dp[ind][A][L];
        
        long sum = 0;
        
        if(A>0)
            sum += helper(ind-1, A-1, 2, dp);
        if(L>0)
            sum += helper(ind-1, A, L-1, dp);
        
        sum += helper(ind-1, A, 2, dp);
        
        return dp[ind][A][L] = (int)(sum%1000000007);
    }
}