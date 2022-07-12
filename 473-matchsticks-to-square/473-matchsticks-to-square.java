class Solution {
    //int[] dp;
    
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        
        int[] square = new int[4];
        
      //  dp = new int[n];
      //  Arrays.fill(dp,-1);
        int sum = 0;
        for(int i : matchsticks) sum += i;
        
        int target = sum/4;
        
        for(int i : matchsticks) if(i> target) return false;
        
        return helper(0,square,matchsticks,sum/4);
    }
    
    public boolean helper(int ind,int[] square, int[] matchsticks,int target){
        if(ind == matchsticks.length){
            if(square[0] == square[1] && square[1] == square[2] && square[2] == square[3]) return true;
            
            return false;
        }
        
        //if(dp[ind] != -1) return dp[ind] == 0?false:true;
        
        for(int i = 0;i<4;i++){
            if(square[i] + matchsticks[ind] > target) continue;
            
            int j = i-1;
            while(j>=0){
                if(square[i] == square[j]) break;
                j--;
            }
            
            if(j != -1) continue;
            
            square[i] += matchsticks[ind];
            if(helper(ind+1,square,matchsticks,target)){// dp[ind] = 1;
                                                 return true;}
            square[i] -= matchsticks[ind];
        }
        
        //dp[ind] = 0;
        return false;
    }
}