class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i : map.values()){
            max = Math.max(max, i);
        }
        
        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(max == entry.getValue()){
                cnt += max;
            }
        }
        
        return cnt;
    }
}