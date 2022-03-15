class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 0,n = nums.length;
        
        for(int i=0;i<n;i=i+2){
            sum += nums[i];
        }
        
        return sum;
    }
}