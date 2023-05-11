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
        
        int[][] dp  = new int[n+1][m+1];
        
        for(int r=n-1; r>=0; r--){
            for(int c=m; c>=0; c--){
                int max = 0;
                
                if(map.containsKey(nums1[r])){
                    for(int inx : map.get(nums1[r])){
                        if(inx > c-1){
                            max = Math.max(max, dp[r+1][inx+1]+1);
                            break;
                        }
                    }
                }
                
                max = Math.max(max, dp[r+1][c]);
                
                dp[r][c] = max;
            }
        }
        
        return dp[0][0];
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