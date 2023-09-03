class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long cnt=0;
        int min=nums[n-1], temp, ceil;
        
        for(int ind=n-2; ind>=0; ind--){
            
            if(nums[ind] > min){
                ceil = (int)Math.ceil((double)nums[ind]/min);
                
                cnt += ceil-1;
                min = (nums[ind]/ceil);
            }
            else if(nums[ind] < min){
                min = nums[ind];
            }
            
        }
        
        return cnt;
    }
}