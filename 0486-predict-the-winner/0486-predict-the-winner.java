class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length, mask=0;
        
        for(int ind=0; ind<n; ind++){
            mask |= (1<<ind);
        }
        
        int[][] dp = new int[mask+1][2];
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        mask = 0;
        mask |= 1;
        mask |= (1<<n-1);
        
        return solve(0, nums, mask, dp)<0 ? false : true;
    }
    
    public int solve(int player, int[] nums, int mask, int[][] dp){
        int[] pos = new int[2];
        Arrays.fill(pos, -1);
        
        int k=0;
        for(int ind=0; ind<21; ind++){
            if((mask&(1<<ind)) != 0){
                pos[k++] = ind;
            }
        }
        
        if(player == 1){
            k=-1;
        }
        else{
            k=1;
        }
        
        if(pos[1]==-1){
            return nums[pos[0]]*k;    
        }
        
        if(dp[mask][player] != -1){
            return dp[mask][player];
        }
        
        int left_mask = 0;
        left_mask |= (1<<pos[1]);
        left_mask |= (1<<(pos[0]+1));
        int left = (k*nums[pos[0]]) + solve((player+1)%2 , nums, left_mask, dp);
        
        int right_mask = 0;
        right_mask |= (1<<pos[0]);
        right_mask |= (1<<(pos[1]-1));
        int right = (k*nums[pos[1]]) + solve((player+1)%2, nums, right_mask, dp);
        
        return dp[mask][player] = player==1? Math.min(left, right) : Math.max(left, right);
    }
}