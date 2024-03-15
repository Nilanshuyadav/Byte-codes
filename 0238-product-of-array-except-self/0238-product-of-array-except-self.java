class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n], suff = new int[n];
        
        pre[0] = nums[0];
        suff[n-1] = nums[n-1];
        
        for(int i=1, j=n-2; i<n; i++, j--){
            pre[i] = pre[i-1]*nums[i];
            suff[j] = suff[j+1]*nums[j];
        }
        
        int[] ans = new int[n];
        
        for(int ind=1; ind<n-1; ind++){
            ans[ind] = pre[ind-1]*suff[ind+1];
        }
        
        ans[0] = suff[1];
        ans[n-1] = pre[n-2];
        
        return ans;
    }
}