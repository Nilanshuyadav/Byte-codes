class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums){
            if(!set.add(i)) return true;
        }
        
        return false;
    }
}