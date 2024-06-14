class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        
        int max = nums[0];
        int sum = 0;
        
        for(int i=1; i<nums.length; i++){
            if(max>=nums[i]){
                max++;
                sum += (max-nums[i]);
            }
            else{
                max = nums[i];
            }
        }
        
        return sum;
    }
}