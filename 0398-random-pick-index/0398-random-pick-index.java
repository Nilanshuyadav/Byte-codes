class Solution {
    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        
        for(int ind=0; ind<nums.length; ind++){
            if(!map.containsKey(nums[ind])){
                map.put(nums[ind], new ArrayList<>());
            }
            
            map.get(nums[ind]).add(ind);
        }
    }
    
    public int pick(int target) {
        List<Integer> al = map.get(target);
        
        return al.get((int)(Math.random()*al.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */