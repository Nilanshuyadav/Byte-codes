class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, l=0, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(l==h) return nums[l];
            
            if((m==0 && nums[m]!=nums[m+1]) || (m==n-1 && nums[m]!=nums[m-1]) || (nums[m-1]!=nums[m] && nums[m]!=nums[m+1])) return nums[m];
            else if((m&1) == 0){
                if(m!=n-1 && nums[m]==nums[m+1]) l = m+1;
                else h = m-1;
            }
            else{
                if(nums[m]==nums[m+1]) h = m-1;
                else l = m+1; 
            }
        }
        
        return -1;
    }
}