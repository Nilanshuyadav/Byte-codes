class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int th = nums.length/3;
        
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>th){
                ans.add(entry.getKey());
            }
        }
        
        return ans;
    }
}