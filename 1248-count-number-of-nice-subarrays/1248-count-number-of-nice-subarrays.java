class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        int sum = 0, cnt=0;
        
        for(int i=0; i<n; i++){
            sum += nums[i]&1;
            
            if(map.containsKey(sum-k)){
                cnt += map.get(sum-k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return cnt;
    }
}