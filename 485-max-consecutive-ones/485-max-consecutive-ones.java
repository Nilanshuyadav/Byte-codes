class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         
        int n = nums.length,len = 0,max = 0;
        
        for(int i=0;i<n;i++){
            if(nums[i] == 1) len++;
            else{
                max = Math.max(max,len);
                len = 0;
            }
        }
        
        max = Math.max(max,len);
        
        return max;
    }
}