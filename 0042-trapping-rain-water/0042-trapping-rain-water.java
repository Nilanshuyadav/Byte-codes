class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pre_max = new int[n], suff_max = new int[n];
        int pre = height[0], suff = height[n-1];
        
        pre_max[0] = pre;
        suff_max[n-1] = suff;
        
        for(int i=1, j=n-2; i<n; i++, j--){
            pre_max[i] = pre;
            suff_max[j] = suff;
            
            pre = Math.max(pre, height[i]);
            suff = Math.max(suff, height[j]);
        }
        
        int ans=0;
        for(int ind=1; ind<n-1; ind++){
            int h = Math.min(pre_max[ind], suff_max[ind])-height[ind];
            
            if(h>0){
                ans += h;
            }
        }
        
        return ans;
    }
}