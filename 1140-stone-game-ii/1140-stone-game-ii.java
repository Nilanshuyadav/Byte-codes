class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suf_sum = new int[n+1];
        suf_sum[n-1] = piles[n-1];
        
        for(int ind=n-2; 0<=ind; ind--)
            suf_sum[ind] = suf_sum[ind+1]+piles[ind];
        
        int[][][] dp = new int[2][n][n+1];
        
        for(int[][] ind: dp)
            for(int inx[] : ind)
                Arrays.fill(inx, -1);
        
        dfs(1, 0, piles, n, dp, 1, suf_sum);
        
        return dp[1][0][1];
    }
    
    public int dfs(int turn, int ind, int[] piles, int n, int[][][] dp, int M, int[] suf_sum){
        if(n<=ind)
            return 0;
        
        int max_val=0, sum=0, temp, temp_sum;
        int index;
        
        for(int x=0; x<(2*M); x++){
            index = ind+x;
            
            if(n<=index)
                break;
            
            if(dp[turn][ind][M] != -1){
                return dp[turn][ind][M];
            }
            
            sum += piles[index];
            
            if(turn == 1){
                temp = dfs(0, index+1, piles, n, dp, Math.max(x+1, M), suf_sum);
            }
            else{
                temp = dfs(1, index+1, piles, n, dp, Math.max(x+1, M), suf_sum);
            }
            
            temp_sum = suf_sum[index+1]-temp;
            max_val = Math.max(max_val, sum+temp_sum);
        }
        
        return dp[turn][ind][M] = max_val;
    }
}