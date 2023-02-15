class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, pivot = n-1;
        
        if(nums[0]>nums[n-1])
            pivot = findPivot(nums);
        
        int first = findTarget(0, pivot, nums, target);
        if(first != -1)
            return first;
        return findTarget(pivot+1, n-1, nums, target);
    }
    
    public int findTarget(int l, int h, int[] nums, int target){
        int m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(nums[m]<target) l=m+1;
            else if(nums[m]>target) h=m-1;
            else return m;
        }
        
        return -1;
    }
    
    public int findPivot(int[] nums){
        int l=0, h=nums.length-1, m;
        
        while(l<h){
            m = l+(h-l)/2;
            
            if(nums[m]<nums[h]) h=m;
            else if(nums[m]>nums[h]) l=m;
            
            if(l+1==h)
                break;
        }
        
        return l;
    }
}