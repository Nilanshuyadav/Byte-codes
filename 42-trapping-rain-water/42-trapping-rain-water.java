class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        
        int[] pre = new int[n];
        int[] suf = new int[n];
        
        pre[0] = height[0]; suf[n-1]= height[n-1];
        
        for(int ind = 1;ind<n;ind++){
            pre[ind] = Math.max(pre[ind-1],height[ind]);
            suf[n-ind-1] = Math.max(suf[n-ind],height[n-ind-1]);
        }
        
        int sum = 0;
        for(int ind = 0;ind<n;ind++){
            if(height[ind]==pre[ind] || height[ind]==suf[ind]) continue;
             sum += Math.min(pre[ind]-height[ind],suf[ind]-height[ind]);
        }
        
        return sum;
    }
}