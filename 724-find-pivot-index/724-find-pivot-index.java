class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0, left_sum = 0;
        
        for(int ind : nums) sum += ind;
        
        for(int ind=0; ind<nums.length; ind++){
            sum -= nums[ind];
            
            if(sum == left_sum) return ind;
            
            left_sum += nums[ind];
        }
        
        return -1;
    }
}