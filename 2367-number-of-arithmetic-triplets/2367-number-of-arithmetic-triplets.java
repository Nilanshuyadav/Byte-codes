class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Map<Integer,Integer> freq = new HashMap<>();
        int ans = 0;
        
        for(int n : nums) freq.put(n,1);
        
        for(int n : nums) if(freq.containsKey(n+diff) && freq.containsKey(n+diff+diff)) ans++;
        
        return ans;
    }
}