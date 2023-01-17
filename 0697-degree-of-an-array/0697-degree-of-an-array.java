class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length, max = 0, last_freq=0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ind : nums)
            map.put(ind, map.getOrDefault(ind, 0)+1);
        
        Map<Integer, List<Integer>> map_index = new HashMap<>();
        
        for(int ind=0; ind<n; ind++){
            List<Integer> al;
            
            if(map_index.containsKey(nums[ind]))
                al = map_index.get(nums[ind]);
            else
                al = new ArrayList<>();
            
            al.add(ind);
            
            map_index.put(nums[ind], al);
        }
        
        int max_freq=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > max_freq){
                max_freq = entry.getValue();
                List<Integer> temp = map_index.get(entry.getKey());
                
                max = temp.get(temp.size()-1) - temp.get(0) + 1;
            }
            else if(entry.getValue() == max_freq){
                List<Integer> temp = map_index.get(entry.getKey());
                
                max = Math.min(max, temp.get(temp.size()-1) - temp.get(0) + 1);
            }
        }
        
        return max;
    }
}