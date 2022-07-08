class Solution {
    int[][][] dp = new int[101][21][101];
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        for(int[][] i : dp){
            for(int[] j : i)
                Arrays.fill(j,-1);
        }
        
        int ans = helper(0,0,0,houses,cost,m,n,target);
        return ans == Integer.MAX_VALUE/2?-1:ans;
    }
    
    public int helper(int i,int l,int t,int[] houses,int[][] cost,int m,int n, int target){
        if(t > target){
            return Integer.MAX_VALUE/2;
        }
        if(i == m){
            return t == target?0:Integer.MAX_VALUE/2;
        }
        
        if(dp[i][l][t] != -1) return dp[i][l][t];
        
        int ans = Integer.MAX_VALUE/2;
        if(houses[i] == 0){
            for(int j = 0;j<n;j++)
                ans = Math.min(ans,cost[i][j] + helper(i+1,j+1,(l == j+1)?t:t+1,houses,cost,m,n,target));
        }
        else{
            ans = Math.min(ans,helper(i+1,houses[i],l == houses[i]?t:t+1,houses,cost,m,n,target));
        }
        
        return dp[i][l][t] = ans;
    }
}