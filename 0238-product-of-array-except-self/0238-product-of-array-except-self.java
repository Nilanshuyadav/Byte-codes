class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        ans[0] = 1;
        
        for(int ind=1; ind<n; ind++){
            ans[ind] = ans[ind-1]*nums[ind-1];
        }
        
        int temp=nums[n-1];
        for(int ind=n-2; ind>=0; ind--){
            ans[ind] = ans[ind]*temp;
            temp *= nums[ind];
        }
        
        return ans;
    }
}