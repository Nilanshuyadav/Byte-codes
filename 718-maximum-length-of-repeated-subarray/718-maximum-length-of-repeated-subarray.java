class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int ind_nums1 = 1; ind_nums1<=n;ind_nums1++){
            for(int ind_nums2=1;ind_nums2<=m;ind_nums2++){
                if(nums1[ind_nums1-1] != nums2[ind_nums2-1]) continue;
                
                dp[ind_nums1][ind_nums2] = 1 + dp[ind_nums1-1][ind_nums2-1];
                
                max = Math.max(max,dp[ind_nums1][ind_nums2]);
            }
        }
        
        return max;
    }
}