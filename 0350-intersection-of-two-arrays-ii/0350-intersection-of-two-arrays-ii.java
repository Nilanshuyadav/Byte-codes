class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i : nums2){
            if(map.containsKey(i) && map.get(i)>0){
                ans.add(i);
                map.put(i, map.get(i)-1);
            }
        }
        
        int[] arr = new int[ans.size()];
        int ind=0;
        
       for(int i : ans){
            arr[ind++] = i;
        }
        
        return arr;
    }
}