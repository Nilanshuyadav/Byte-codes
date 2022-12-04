class Solution {
    public int minimumAverageDifference(int[] nums) {
        long first = 0, last = 0;
        
        for(int ind : nums)
            last += ind;
        
        int min = Integer.MAX_VALUE, ans = 0;
        int n = nums.length; 
        
        for(int ind=0; ind<n; ind++){
            first += nums[ind];
            last -= nums[ind];
            
            int left_average = (int)(first/(ind+1));
            int right_average = 0;
            if(ind != n-1)
                right_average = (int)(last/(n-ind-1));
            
            int ab_diff = Math.abs(left_average - right_average);
            
            if(ab_diff < min){
                ans = ind;
                min = ab_diff;
            }
        }
        
        return ans;
    }
}