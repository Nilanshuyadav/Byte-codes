class Solution {
    int N,M;
    public int maximumScore(int[] nums, int[] m) {
        N = nums.length;
        M = m.length;
        
        int[] dp = new int[M+1];
        
        for(int i=M-1;i>=0;i--){
            int[] temp = new int[M+1];
            for(int j=i;j>=0;j--){
                int high = N-1-(i-j);
                int left = (m[i]*nums[j]) + dp[j+1];
                int right = (m[i]*nums[high]) + dp[j];
                
                temp[j] = Math.max(left,right);
            }
            dp = temp;
        }
        
        return dp[0];
    }
    
}





// class Solution {
//     int N, M;
//     public int maximumScore(int[] nums, int[] multipliers) {
//         N = nums.length;
//         M = multipliers.length;
// 	    return helper(nums, multipliers, 0, 0, new Integer[M][M]);
//     }

//     private int helper(int[] nums, int[] multipliers, int left, int index, Integer[][] dp) {
// 	    int right = N - 1 - (index - left);
// 	    if (index == M) return 0;

// 	    if (dp[left][index] != null) return dp[left][index];

// 	  //  int res = Math.max(
//         int lef = (nums[left] * multipliers[index]) + helper(nums, multipliers, left+1, index+1, dp); 
//          int righ = (nums[right] * multipliers[index]) + helper(nums, multipliers, left, index+1, dp);

//         return dp[left][index] = Math.max(lef,righ);
	    
//     }
// }




