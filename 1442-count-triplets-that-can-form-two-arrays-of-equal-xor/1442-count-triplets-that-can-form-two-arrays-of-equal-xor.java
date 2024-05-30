class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        int num, 
            xor=0, 
            cnt=0,
            len;
        
        List<Integer> al;
        
        for(int i=0; i<n; i++){
            num = arr[i];
            
            xor ^= num;
            
            if(map.containsKey(xor)){
                al = map.get(xor);
                
                for(int j : al){
                    len = i-j;
                    cnt += len-1;
                }
            }
            
            al = map.getOrDefault(xor, new ArrayList<>());
            
            al.add(i);
            map.put(xor, al);
        }
        
        return cnt;
    }
}