class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        Boolean[][] dp = new Boolean[n][n];
        
        return solve(0, stones, 0, n, dp);
    }
    
    
    public boolean solve(int ind, int[] stones, int k, int n, Boolean[][] dp){
        if(ind == n-1){
            return true;
        }
        
        if(dp[ind][k] != null){
            return dp[ind][k];
        }
        
        boolean bool = false;
        
        if(k-1>0){
            int temp = contains(stones, n, stones[ind]+k-1);
            
            if(temp!=-1)
                bool |= solve(temp, stones, k-1, n, dp);
        }
        
        if(k>0){
            int temp = contains(stones, n, stones[ind]+k);
            
            if(temp!=-1)
                bool |= solve(temp, stones, k, n, dp);
        }
        
        if(k+1>0){
            int temp = contains(stones, n, stones[ind]+k+1);
            
            if(temp!=-1)
                bool |= solve(temp, stones, k+1, n, dp);
        }
        
        return dp[ind][k] = bool;
    }
    
    public int contains(int[] stones, int n, int tar){
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(stones[m] == tar){
                return m;
            }
            else if(stones[m] < tar){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return -1;
    }
}