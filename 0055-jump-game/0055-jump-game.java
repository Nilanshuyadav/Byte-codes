class Solution {
    public boolean canJump(int[] nums) {
        int max_reach = 0;
        
        for(int ind=0; ind<nums.length; ind++){
            if(ind>max_reach)
                return false;
            
            max_reach = Math.max(max_reach, ind+nums[ind]);
        }
        
        return true;
    }
}