class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i : hand){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> al = new ArrayList<>(map.keySet());
        int cnt=0, i, temp;
        
        for(int a=0; a<al.size(); a++){
            i = al.get(a);
            cnt = groupSize;
            temp = i;
            
            if(!map.containsKey(temp)) continue;
            
            map.put(temp, map.get(temp)-1);
            
            if(map.get(temp)==0){
                map.remove(temp);
            }
            else{
                a--;
            }
            
            while(cnt-->1){
                if(!map.containsKey(temp+1)) return false;
                temp = temp+1;
                
                map.put(temp, map.get(temp)-1);
            
                if(map.get(temp)==0){
                    map.remove(temp);
                }
            }
        }
        
        return true;
    }
}