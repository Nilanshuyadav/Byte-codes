class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int pre_ind = -(k+1);
        
        for(int ind=0; ind<nums.length; ind++){
            if(nums[ind] == 1){
                if(ind - pre_ind <= k)
                    return false;
                
                pre_ind = ind;
            }
        }
        
        return true;
    }
}