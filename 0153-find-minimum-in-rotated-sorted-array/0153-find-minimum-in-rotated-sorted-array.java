class Solution {
    public int findMin(int[] nums) {
        int l=0, h=nums.length-1, m;
        
        if(nums[l] <= nums[h]) return nums[l];
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(nums[m]>nums[m+1]){
                return nums[m+1];
            }
            else if(nums[l] <= nums[m]){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return -1;
    }
}