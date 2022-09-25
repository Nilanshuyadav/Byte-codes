class Solution {
    public int pivotIndex(int[] nums) {
        int[] pre = new int[nums.length], suff = new int[nums.length];
        int n = nums.length;
        
        if(n==1) return 0;
        
        for(int ind=1; ind<nums.length; ind++){
            suff[ind] = nums[ind-1] + suff[ind-1];
            pre[n-ind-1] = nums[n-ind]+pre[n-ind];
        }
        
        for(int ind=0; ind<n; ind++)
            if(suff[ind] == pre[ind]) return ind;
        
        return -1;
    }
}