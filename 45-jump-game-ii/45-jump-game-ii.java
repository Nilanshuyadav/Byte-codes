class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        if(n<=1) return 0;
        for(int i=0;i<n;i++){
            for(int k = i+1;k<=i+nums[i] && k<n ; k++){
                dp[k] = Math.min(dp[k],dp[i]+1);
            }
        }
        
        return dp[n-1];
    }
}