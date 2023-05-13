class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high+2];
        
        dp[high+1] = 0;
        
        for(int ind=high; ind>=0; ind--){
            dp[ind] = low<=ind+zero && ind+zero<=high ? dp[ind+zero]+1 : dp[Math.min(ind+zero, high+1)];
            dp[ind] += low<=ind+one && ind+one<=high ? dp[ind+one]+1 : dp[Math.min(ind+one, high+1)];
            
            dp[ind] = dp[ind]%1000000007;
        }
        
        // return (int)solve(0, low, high, zero, one, dp);
        
        return (int)dp[0];
    }
    
    public long solve(int size, int low, int high, int zero, int one, long dp[]){
        if(size>high){
            return 0;
        }
        
        if(dp[size] != -1){
            return dp[size];
        }
        
        long temp1 = low<=size+zero && size+zero<=high ? solve(size+zero, low, high, zero, one, dp)+1 :                       solve(size+zero, low, high, zero, one, dp);
        
        long temp2 = low<=size+one && size+one<=high ? solve(size+one, low, high, zero, one, dp)+1 :
            solve(size+one, low, high, zero, one, dp);
        
        return dp[size] = (temp1+temp2)%1000000007;
    }
}