class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n+1][7][16];
        
        for(int ind[][] : dp)
            for(int inx[] : ind)
                Arrays.fill(inx, -1);
        
        return dfs(n, 0, 0, rollMax, dp);
    }
    
    public int dfs(int arr_size, int preValue, int freq, int[] rollMax, int[][][] dp){
        if(arr_size==0)
            return 1;
        
        if(dp[arr_size][preValue][freq] != -1)
            return dp[arr_size][preValue][freq];
        
        long ans = 0;
        
        for(int ind=1; ind<=6; ind++){
            if(ind==preValue){
                if(freq<rollMax[ind-1])
                    ans += dfs(arr_size-1, preValue, freq+1, rollMax, dp);
                else
                    continue;
            }
            else{
                ans += dfs(arr_size-1, ind, 1, rollMax, dp);
            }
            
            ans = ans%1000000007;
        }
        
        return dp[arr_size][preValue][freq] = (int)ans;
    }
}