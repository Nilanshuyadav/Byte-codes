class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        
        for(int ind=1; ind<nums.length; ind++){
            min = Math.min(min, nums[ind]-nums[ind-1]);
        }
        
        return min;
    }
}