class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        if(endPos<startPos-k || startPos+k<endPos)
            return 0;
        
        int[][] dp = new int[2002][k+1];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
        
        return dfs(1001, 1001+(endPos-startPos), k, dp);
    }
    
    public int dfs(int start, int end, int k, int[][] dp){
        if(k==0){
            return start==end?1:0;
        }        
        
        if(dp[start][k] != -1)
            return dp[start][k];
        
        int back = 0, forward=0;
        
        if(k>0){
            back += dfs(start-1, end, k-1, dp);
            forward += dfs(start+1, end, k-1, dp);
        }
        
        return dp[start][k] = (back+forward)%1000000007;
    }
}