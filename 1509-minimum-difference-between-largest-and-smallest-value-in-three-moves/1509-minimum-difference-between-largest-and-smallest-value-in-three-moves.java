class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n<5) return 0;
        
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        
        for(int i=0; i<4; i++){
            min = Math.min(min, nums[n+i-4]-nums[i]);
        }
        
        return min;
    }
}