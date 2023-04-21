class Solution {
    // Map<String, Long> dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // dp_map = new HashMap<>();
        int m = group.length;
        int total = 0;
        
        for(int ind : profit){
            total += ind;
        }
        
        int[][][] dp = new int[m+1][n+1][minProfit+1];
        
        for(int p = 0; p<=minProfit; p++){
            for(int temp_n=0; temp_n<=n; temp_n++){
                if(p>=minProfit){
                    dp[m][temp_n][p] = 1;
                }
            }
        }
        
        long pick, not_pick;
        for(int ind=m-1; ind>=0; ind--){
            for(int p=0; p<= minProfit; p++){
                for(int temp_n=0; temp_n<=n; temp_n++){
                    
                    pick = 0;
                    
                    if(temp_n>=group[ind])
                        pick = dp[ind+1][temp_n-group[ind]][Math.min(minProfit, p+profit[ind])];
                    
                    not_pick = dp[ind+1][temp_n][p];
                    
                    dp[ind][temp_n][p] = (int)((pick+not_pick)%1000000007);
                }
            }
        }
        
        
        
        return dp[0][n][0];
    }
    
//     public long solve(int ind, int n, int[] profit, int[] group, int curr_profit, int minProfit){
//         if(ind == profit.length){
//             return curr_profit>=minProfit ? 1 : 0;
//         }
        
//         String st = ""+ind+","+curr_profit+","+n;
        
//         if(dp.containsKey(st)){
//             return dp.get(st);
//         }
        
//         long pick = 0, notPick=0;
        
//         if(group[ind] <= n){
//             pick = solve(ind+1, n-group[ind], profit, group, curr_profit+profit[ind], minProfit);
//         }
        
//         notPick = solve(ind+1, n, profit, group, curr_profit, minProfit);
        
//         long ans = (pick+notPick)%1000000007;
        
//         dp.put(st, ans);
//         return ans;
//     }
}