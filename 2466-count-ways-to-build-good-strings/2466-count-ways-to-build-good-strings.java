class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+Math.max(zero, one)+1];
        Arrays.fill(dp, -1);
        
        return dfs(low, high, zero, one, 0, dp);
    }
    
    public int dfs(int low, int high, int zero, int one, int size, int[] dp){
        if(high<size)
            return 0;
        
        if(dp[size] != -1)
            return dp[size];
        
        int temp = 0;
        
        temp += dfs(low, high, zero, one, size+zero, dp);
        temp += dfs(low, high, zero, one, size+one, dp);
        
        if(low<=size && size<=high)
            temp++;
        
        return dp[size] = temp%1000000007;
    }
}