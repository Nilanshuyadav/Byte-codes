class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] pre = new int[n], suf = new int[n];
        int max = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            max = Math.max(height[i],max);
            pre[i] = max;
            
            max2 = Math.max(height[n-i-1],max2);
            suf[n-i-1] = max2;
        }
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            ans += Math.min(pre[i],suf[i])-height[i];
        }
        
        return ans;
    }
}