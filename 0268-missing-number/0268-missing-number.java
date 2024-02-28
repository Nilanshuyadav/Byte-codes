class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        
        for(int ind : nums){
            sum += ind;
        }
        
        int max = ((n)*(n+1))/2;
        
        return sum==max?0:max-sum;
    }
}