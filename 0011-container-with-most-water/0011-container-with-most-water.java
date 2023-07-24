class Solution {
    public int maxArea(int[] height) {
        int ans=0, l=0, r=height.length-1;
        
        while(l<r){
            ans = Math.max(ans, (r-l)*(Math.min(height[l], height[r])));
            
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        
        return ans;
    }
}