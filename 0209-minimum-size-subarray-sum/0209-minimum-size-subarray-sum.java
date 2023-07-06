class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0, min=(int)1e8, i=-1, j=0;
        
        for(j=0; j<nums.length; j++){
            sum += nums[j];
            
            while(sum >= target){
                min = Math.min(min, j-i);

                i++;
                sum -= nums[i];
            }
        }
        
        return min==(int)1e8 ? 0 : min;
    }
}