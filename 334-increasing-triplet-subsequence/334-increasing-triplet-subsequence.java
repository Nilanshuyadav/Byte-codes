class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n =nums.length;
        
        if(n<3) return false;
        
        int i=Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
                
        for(int l=0;l<n;l++){
            if(nums[l]<=i) i = nums[l];
            else if(nums[l]<=j) j = nums[l];
            else return true;
        }
        
        return false;
    }
}