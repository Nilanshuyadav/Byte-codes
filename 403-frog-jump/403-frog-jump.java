class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        TreeMap<Integer,HashSet<Integer>> map = new TreeMap<>();
        HashSet<Integer> s = new HashSet<>();
        s.add(1);
        map.put(0,s);
        
        for(int i =1;i<n;i++) map.put(stones[i],new HashSet<Integer>());
        
        for(Map.Entry<Integer,HashSet<Integer>> entry : map.entrySet()){
            for(int i : entry.getValue()){
                if(i==0) continue;
                int temp = entry.getKey()+i;
                if(temp == stones[n-1]) return true;
                if(map.containsKey(temp)){
                    HashSet<Integer> set = map.get(temp);
                    set.add(i-1);
                    set.add(i);
                    set.add(i+1);
                    map.put(temp,set);
                }
            }
        }
        
        System.out.println(map);
        return false;
    }
}