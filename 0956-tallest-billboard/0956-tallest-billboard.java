class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int[][] dp = new int[n+1][10001];
        
        
        for(int ind=0; ind<10001; ind++){
            dp[n][ind] = ind==5000? 0 : -(int)1e8;
        }
        
        int bucket1, bucket2, bucket3;
        
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<10001; j++){
                bucket1 = j-rods[i] >=0 ? dp[i+1][j-rods[i]]+rods[i] : -(int)1e8;
                bucket2 = j+rods[i] <10001 ? dp[i+1][j+rods[i]] : -(int)1e8;
                bucket3 = dp[i+1][j];
                
                dp[i][j] = Math.max(bucket1, Math.max(bucket2, bucket3));
            }
        }
                
        return dp[0][5000];
    }
    
//     public int solve(int ind, int n, int diff, int[] rods, int[][] dp){
//         if(ind == n){
//             return diff==5000 ? 0 : -(int)1e8;
//         }
        
//         if(dp[ind][diff] != -1){
//             return dp[ind][diff];
//         }
        
//         int bucket1 = rods[ind] + solve(ind+1, n, diff-rods[ind], rods, dp);
//         int bucket2 = solve(ind+1, n, diff+rods[ind], rods, dp);
//         int bucket3 = solve(ind+1, n, diff, rods, dp);
        
//         return dp[ind][diff] = Math.max(bucket1, Math.max(bucket2, bucket3));
//     }
}