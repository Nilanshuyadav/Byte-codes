class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ind : nums){
            set.add(ind);
            map.put(ind, map.getOrDefault(ind, 0)+1);
        }
        
        int cnt=0, half=0;
        for(int ind : set){
            if((k!=0 && set.contains(ind+k))) {
                cnt++;
            }
        }
        
        for(int ind : nums){
            if(k==0 && set.contains(ind) && map.get(ind)>1){
                set.remove(ind);
                cnt++;
            }
        }
        
        return cnt + half/2;
    }
}