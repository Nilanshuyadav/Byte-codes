// class Solution {
//     public int maximumScore(int[] nums, int[] m) {
        
//         int[][] dp = new int[100000][1000];
        
//         for(int i[] : dp)
//             Arrays.fill(i,-1);
        
//         return dfs(0,0,nums, m,dp);
//     }
    
//     public int dfs(int ind,int low, int[] nums, int[] m, int[][] dp){
//         int high = nums.length -1-(ind-low);
//         if(ind == m.length) return 0;
        
//         if(dp[low][ind] != -1) return dp[low][ind];
        
//         int left = (m[ind]*nums[low]) + dfs(ind+1,low+1,nums,m,dp);
//         int right = (m[ind]*nums[high]) + dfs(ind+1,low,nums,m,dp);
        
//         return dp[low][ind] = Math.max(left,right);
//     }
// }





class Solution {
    int N, M;
    public int maximumScore(int[] nums, int[] multipliers) {
        N = nums.length;
        M = multipliers.length;
	    return helper(nums, multipliers, 0, 0, new Integer[M][M]);
    }

    private int helper(int[] nums, int[] multipliers, int left, int index, Integer[][] dp) {
	    int right = N - 1 - (index - left);
	    if (index == M) return 0;

	    if (dp[left][index] != null) return dp[left][index];

	    int res = Math.max(
            nums[left] * multipliers[index] + helper(nums, multipliers, left+1, index+1, dp), 
            nums[right] * multipliers[index] + helper(nums, multipliers, left, index+1, dp));

        dp[left][index] = res;
	    return res;
    }
}




