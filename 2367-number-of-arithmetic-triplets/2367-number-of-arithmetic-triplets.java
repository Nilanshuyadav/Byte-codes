class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        
        for(int n : nums) set.add(n);
        
        for(int n : nums) if(set.contains(n-diff) && set.contains(n+diff)) ans++;
        
        return ans;
    }
}