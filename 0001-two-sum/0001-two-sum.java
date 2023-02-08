class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int ind=0; ind<n; ind++){
            if(map.containsKey(target-nums[ind])){
                return new int[]{map.get(target-nums[ind]), ind};
            }
            map.put(nums[ind], ind);
        }
        
        return new int[0];
    }
}