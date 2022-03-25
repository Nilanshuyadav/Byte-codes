class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            
            if(max<sum) max = sum;
            
            if(sum<0){
                // max = Math.max(max,sum-nums[i]);
                sum = 0;
            }
        }
        
        // max = Math.max(max,sum);
        
        return max;
    }
}