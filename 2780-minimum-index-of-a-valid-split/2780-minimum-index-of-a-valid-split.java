class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>() , map2 = new HashMap<>();
        
        for(int i=0; i<n; i++){
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        
        int fre1, fre2, size1, size2;
        
        for(int i=0; i<n; i++){
            map2.put(nums.get(i), map2.getOrDefault(nums.get(i), 0) + 1);
            
            fre1 = map2.get(nums.get(i));
            fre2 = map.get(nums.get(i))-fre1;
            
            size1 = i+1;
            size2 = n-i-1;
            
            if((2*fre1)>size1 && (2*fre2)>size2){
                return i;
            }
        }
        
        return -1;
    }
}