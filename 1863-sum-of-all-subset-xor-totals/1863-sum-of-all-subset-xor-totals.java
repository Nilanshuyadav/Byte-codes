class Solution {
    int xorSum;
    public int subsetXORSum(int[] nums) {
        xorSum = 0;
        findAllSubsets(nums.length-1, nums, 0);
        
        return xorSum;
    }
    
    public void findAllSubsets(int ind, int[] nums, int xor){
        if(ind == -1){
            xorSum += xor;
            return;
        }
        
        findAllSubsets(ind-1, nums, xor^nums[ind]);
        findAllSubsets(ind-1, nums, xor);
    }
}