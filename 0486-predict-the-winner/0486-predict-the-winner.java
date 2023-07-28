class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length, mask=0;
        
        // for(int ind=0; ind<n; ind++){
        //     mask |= (1<<ind);
        // }
        
        int[][][] dp = new int[21][21][2];
        for(int i[][] : dp){
            for(int j[] : i){
                Arrays.fill(j, -1);    
            }
        }
        
        // mask = 0;
        // mask |= 1;
        // mask |= (1<<n-1);
        
        return solve(0, nums, 0, n-1, dp)<0 ? false : true;
    }
    
    public int solve(int player, int[] nums, int pos1, int pos2, int[][][] dp){
//         int[] pos = new int[2];
//         Arrays.fill(pos, -1);
        
//         int k=0;
//         for(int ind=0; ind<21; ind++){
//             if((mask&(1<<ind)) != 0){
//                 pos[k++] = ind;
//             }
//         }
        
        
        int k;
        if(player == 1){
            k=-1;
        }
        else{
            k=1;
        }
        
        if(pos1==pos2){
            return nums[pos1]*k;    
        }
        
        if(dp[pos1][pos2][player] != -1){
            return dp[pos1][pos2][player];
        }
        
        // int left_mask = 0;
        int left = (k*nums[pos1]) + solve((player+1)%2 , nums, pos1+1, pos2, dp);
        
        // int right_mask = 0;
        int right = (k*nums[pos2]) + solve((player+1)%2, nums, pos1, pos2-1, dp);
        
        return dp[pos1][pos2][player] = player==1? Math.min(left, right) : Math.max(left, right);
    }
}