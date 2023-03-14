class Solution {
    public int minSubarray(int[] nums, int p) {
        long total=0;
        int n = nums.length;
        
        for(int ind : nums){
            total += ind;
        }
        
        if(total%p == 0)    return 0;
        if(total < p)   return -1;
        
        long num = (int)(total%p);
        
        Map<Long, Integer> map = new HashMap<>();
        
        total = 0;
        int min = Integer.MAX_VALUE;
        for(int ind=0; ind<n; ind++){
            total += nums[ind];
            
            if(total%p == num)    min = Math.min(min, ind+1);
            if(map.containsKey(((total%p)-num + p)%p))    min = Math.min(min, ind-map.get(((total%p)-num + p)%p));
            
            map.put(total%p, ind);
        }
        
        return min>=n ? -1 : min;
    }
}