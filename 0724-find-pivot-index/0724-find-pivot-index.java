class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0, n=nums.length;
        for(int ind=0; ind<n; ind++)
            total += nums[ind];
        
        int left_sum=0;
        for(int ind=0; ind<n; ind++){
            if(left_sum == total-left_sum-nums[ind])
                return ind;
            
            left_sum += nums[ind];
        }
        
        return -1;
    }
}