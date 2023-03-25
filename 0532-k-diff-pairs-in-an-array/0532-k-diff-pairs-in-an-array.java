class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ind : nums){
            map.put(ind, map.getOrDefault(ind, 0)+1);
        }
        
        int cnt=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if((k>0 && map.containsKey(entry.getKey()+k)) || (k==0 && map.get(entry.getKey())>1))
                cnt++;
        }
        
        return cnt;
    }
}