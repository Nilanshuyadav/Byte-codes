class Solution {
    public int[] buildArray(int[] nums) {
        helper(nums, 0);
        return nums;
    }

    public void helper(int[] nums, int s){
        if(s<nums.length){
            int next = nums[nums[s]];
            helper(nums, s+1);
            nums[s] = next;
        }
    }
}