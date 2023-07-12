class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        
        for(int ind : nums){
            set.add(ind);
        }
        
        for(int ind=0; ind<moveFrom.length; ind++){
            set.remove(moveFrom[ind]);
            set.add(moveTo[ind]);
        }
        
        List<Integer> al = new ArrayList<>(set);
        
        Collections.sort(al);
        
        return al;
    }
}