class Solution {
    public int search(int[] nums, int target) {
        for(int ind=0; ind<nums.length; ind++)
            if(nums[ind] == target)
                return ind;
        
        return -1;
    }
}