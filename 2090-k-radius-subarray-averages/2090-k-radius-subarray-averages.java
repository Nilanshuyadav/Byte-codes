class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n];
        pre[0] = nums[0];
        
        for(int ind=1; ind<n; ind++){
            pre[ind] = nums[ind]+pre[ind-1];
        }
        
        int[] ans = new int[n];
        int d = (2*k)+1;
        
        for(int ind=0; ind<n; ind++){
            if(ind-k<0 || n<=ind+k){
                ans[ind] = -1;
            }
            else{
                ans[ind] = (int)((pre[ind+k]-pre[ind-k]+nums[ind-k])/d);
            }
        }
        
        return ans;
    }
}