class Solution {
    public int maxSubArray(int[] nums) {
        long sum = 0, max=-10000;
        int ans = -10000;
        
        for(int ind : nums){
            sum += ind;
            
            ans = Math.max(ans, ind);
            
            if(sum < 0){
                sum = 0;
                continue;
            }
            
            max = Math.max(max, sum);
        }
        
        return Math.max((int)max, ans);
    }
}