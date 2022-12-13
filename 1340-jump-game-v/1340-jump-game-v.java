class Solution {
    public int maxJumps(int[] arr, int d) {
        int max = 0, n=arr.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        for(int ind=0; ind<n; ind++){
            max = Math.max(max, dfs(ind, arr, n, d, dp));
        }
        
        return max;
    }
    
    public int dfs(int ind, int[] arr, int n, int d, int[] dp){
        if(dp[ind] != -1)
            return dp[ind];
        
        int max_jump = 0;
        
        int from = ind-1, to = Math.max(0,ind-d);
        
        for(int inx=from; inx>=to; inx--){
            if(arr[inx] < arr[ind]){
                max_jump = Math.max(max_jump, dfs(inx, arr, n, d, dp));
            }    
            else
                break;
        }
        
        from = ind+1;
        to = Math.min(n-1, ind+d);
        
        for(int inx=from; inx<=to; inx++){
            if(arr[inx] < arr[ind]){
                max_jump = Math.max(max_jump, dfs(inx, arr, n, d, dp));
            }    
            else
                break;
        }
        
        return dp[ind] = 1+max_jump;
    }
}