class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt=0, sum=0;
        
        map.put(0, 1);
        
        for(int ind : nums){
            sum += ind;
            
            if(map.containsKey(sum-goal)){
                cnt += map.get(sum-goal);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return cnt;
    }
}