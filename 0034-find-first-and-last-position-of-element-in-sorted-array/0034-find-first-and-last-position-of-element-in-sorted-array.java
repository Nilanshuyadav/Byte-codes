class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        
        int l=0, h=n-1, m;
        
        if(n==0 || nums[h] < target || target < nums[l]){
            return new int[]{-1, -1};
        }
        
        int i=-1, j=-1;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(nums[m] < target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        i=h+1;
        
        if(nums[i] != target) return new int[]{-1, -1};
        
        l=0;
        h=n-1;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(target < nums[m]){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return new int[]{i, l-1};
    }
}