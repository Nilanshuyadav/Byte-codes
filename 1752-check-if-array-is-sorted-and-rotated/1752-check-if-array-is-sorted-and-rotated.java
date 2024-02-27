class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int i=0, pre=-1;
        
        for(int ind=0; ind<n; ind++){
            i = nums[i]>=nums[ind]?ind:i;
        }
        
        while(i>0 && nums[i-1]==nums[i]) i--;
        
        for(int ind=i+1; ind<i+n; ind++){
            if(nums[(ind-1)%n]>nums[(ind)%n]){
                return false;
            }
        }
        
        return true;
    }
}