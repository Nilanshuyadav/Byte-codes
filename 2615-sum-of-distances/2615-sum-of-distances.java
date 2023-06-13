class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] output = new long[n];
        
        Map<Integer, Long> sum = new HashMap<>(), count = new HashMap<>();
        
        for(int ind=0; ind<n; ind++){
            if(!sum.containsKey(nums[ind])){
                sum.put(nums[ind], 0l);
                count.put(nums[ind], 0l);
            }
            
            output[ind] = (count.get(nums[ind]) * ind) - sum.get(nums[ind]);
            
            count.put(nums[ind], count.get(nums[ind]) + 1);
            sum.put(nums[ind], sum.get(nums[ind]) + ind);
        }
        
        
        sum.clear();
        count.clear();
        
        for(int ind=n-1; 0<=ind; ind--){
            if(!sum.containsKey(nums[ind])){
                sum.put(nums[ind], 0l);
                count.put(nums[ind], 0l);
            }
            
            output[ind] += sum.get(nums[ind]) - (count.get(nums[ind]) * ind);
            
            count.put(nums[ind], count.get(nums[ind]) + 1);
            sum.put(nums[ind], sum.get(nums[ind]) + ind);
        }
        
        return output;
    }
}