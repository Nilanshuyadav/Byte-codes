class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max_sum=Integer.MIN_VALUE, temp_max_sum=0, temp_min_sum=0, min_sum=Integer.MAX_VALUE;
        int total_sum = 0;
        
        for(int ind : nums){
            temp_max_sum += ind;
            max_sum = Math.max(max_sum, temp_max_sum);
            
            if(temp_max_sum<0)
                temp_max_sum = 0;
            
            temp_min_sum += ind;
            min_sum = Math.min(min_sum, temp_min_sum);
            
            if(temp_min_sum>0)
                temp_min_sum = 0;
            
            total_sum += ind;
        }
        
        if(total_sum == min_sum)
            return max_sum;
        
        return Math.max(max_sum, (total_sum - min_sum));
    }
}