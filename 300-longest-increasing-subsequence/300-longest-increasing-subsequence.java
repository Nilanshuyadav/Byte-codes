class Solution {
    int[] dp;
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        dp = new int[n];
        Arrays.fill(dp,-1);

        int temp,max = Integer.MIN_VALUE;;
        
        for(int i=0;i<n;i++){
            temp = function(nums,i);
            
            if(temp > max) max = temp;
        }        
        
        return max;
    }
    
    public int function(int[] nums,int ind){
        int n = nums.length;
        
        if(ind == n-1){
            
            return 1;
        }
        
        if(dp[ind] != -1) return dp[ind]+1;
        
        int max = 0, i = 0;
        for(i=ind+1;i<n;i++){
            if(nums[i] > nums[ind])
                max = Math.max(max,function(nums,i));
        }
        
        dp[ind] = max;
        return max+1;
    }
}