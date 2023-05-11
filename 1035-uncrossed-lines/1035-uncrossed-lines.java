class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n=nums1.length, m=nums2.length;
        
        List<Integer> al;
        for(int ind=0; ind<m; ind++){
            if(!map.containsKey(nums2[ind])){
                map.put(nums2[ind], new ArrayList<>());
            }
            
            map.get(nums2[ind]).add(ind);
        }
        
        int[][] dp  = new int[501][501];
        for(int ind[] : dp){
            Arrays.fill(ind, -1);
        }
        
        return solve(0, nums1, map, -1, dp);
    }
    
    public int solve(int ind, int[] nums, Map<Integer, List<Integer>> map, int pre, int[][] dp){
        if(ind == nums.length){
            return 0;
        }
        
        if(dp[ind][pre+1] != -1){
            return dp[ind][pre+1];
        }
        
        int max=0;
        
        if(map.containsKey(nums[ind])){
            for(int inx : map.get(nums[ind])){
                if(inx > pre){
                    max = Math.max(max, solve(ind+1, nums, map, inx, dp)+1);
                    break;
                }
            }    
        }
        
        max = Math.max(max, solve(ind+1, nums, map, pre, dp));
        
        return dp[ind][pre+1] = max;
    }
}