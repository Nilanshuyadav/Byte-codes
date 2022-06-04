class Solution {
    public int majorityElement(int[] nums) {
     
        int n = nums.length;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i: nums) map.put(i,map.getOrDefault(i,0)+1);
        
        int maj = n/2;
        
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            if(entry.getValue() > maj)
                return entry.getKey();
        
        return 1;
    }
}