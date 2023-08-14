class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length, l=0, h=n-1, m;
        
        if(target==nums[l] || target==nums[h]) return true;
        
        while(l<=h){
            while(l<h && nums[l]==nums[l+1]) l++;
            while(l<h && nums[h]==nums[h-1]) h--;
            
            if(l>h) return false;
            
            m = l+(h-l)/2;
            
            if(target == nums[m]){
                return true;
            }
            else if(nums[m]<nums[h]){
                if(nums[m]<target && target<=nums[h]){
                    l = m+1;
                }
                else{
                    h = m-1;
                }
            }
            else{
                if(nums[l]<=target && target<nums[m]){
                    h = m-1;
                }
                else{
                    l = m+1;
                }
            }
        }
        
        return false;
    }
}