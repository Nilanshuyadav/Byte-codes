class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> check = new HashSet<>(), ans = new HashSet();
        
        for(int i : nums1){
            check.add(i);
        }
        
        for(int i : nums2){
            if(check.contains(i)){
                ans.add(i);
            }
        }
        
        int res[] = new int[ans.size()], ind=0;
        
        for(int i : ans){
            res[ind++] = i;
        }
        
        return res;
    }
}