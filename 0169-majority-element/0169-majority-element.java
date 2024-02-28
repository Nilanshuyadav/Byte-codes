class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int maj = n/2;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ind=0; ind<n; ind++){
            map.put(nums[ind], map.getOrDefault(nums[ind], 0) + 1);
            
            if(map.get(nums[ind])>maj){
                return nums[ind];
            }
        }
        
        return 0;
    }
}