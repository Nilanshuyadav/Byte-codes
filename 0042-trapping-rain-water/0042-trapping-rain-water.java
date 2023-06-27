class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n], right = new int[n];
        
        int max=0;
        for(int ind=0; ind<n; ind++){
            max = Math.max(max, height[ind]);
            
            left[ind] = max;
        }
        
        max=0;
        for(int ind=n-1; ind>=0; ind--){
            max = Math.max(max, height[ind]);
            
            right[ind] = max;
        }
        
        int total=0;
        
        for(int ind=0; ind<n; ind++){
            total += (Math.min(left[ind], right[ind]) - height[ind]);
        }
        
        return total;
    }
}