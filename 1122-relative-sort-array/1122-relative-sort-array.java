class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i : arr1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int ind=0, temp;
        
        for(int i : arr2){
            temp = map.get(i);
            
            while(temp-->0){
                arr1[ind++] = i;
            }
            
            map.remove(i);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            temp = entry.getValue();
            
            while(temp-->0){
                arr1[ind++] = entry.getKey();
            }
            
        }
        
        return arr1;
    }
}