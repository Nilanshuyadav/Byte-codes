class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        int n = nums.length;
        
        long z=0, o=1;
        
        map.put(z, o);
        long xor=0, cnt=0;
        
        for(int ind=0; ind<n; ind++){
            xor ^= nums[ind];
            
            if(map.containsKey(xor)){
                cnt += map.get(xor);
            }
            
            map.put(xor, map.getOrDefault(xor, z)+1);
        }
        
        return cnt;
    }
}