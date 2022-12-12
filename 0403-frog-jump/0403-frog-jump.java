class Solution {
    public boolean canCross(int[] stones) {
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        int n = stones.length;
        
        for(int ind=0; ind<n; ind++)
            map.put(stones[ind], new HashSet<>());
        
        Set<Integer> temp = map.get(0);
        temp.add(1);
        
        map.put(0, temp);
        
        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            int to, from = entry.getKey();
            
            for(int ind : entry.getValue()){
                to = from+ind;
                
                if(map.containsKey(to)){
                    if(ind!=1)
                        map.get(to).add(ind-1);
                    map.get(to).add(ind);
                    map.get(to).add(ind+1);
                }
            }    
        }
        
        return !map.get(stones[n-1]).isEmpty();
    }
}