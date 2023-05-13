class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high+1];
        Arrays.fill(dp, -1);
        
        return (int)solve(0, low, high, zero, one, dp);
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