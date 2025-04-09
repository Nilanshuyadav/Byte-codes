class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums){
            set.add(i);
        }
        
        List<Integer> al = new ArrayList<>();
        
        for(int i : set){
            al.add(i);
        }
        
        Collections.sort(al);
        
        if(al.get(0) < k) return -1;
        else if(al.get(0) == k) return al.size()-1;
        return al.size();
    }
}