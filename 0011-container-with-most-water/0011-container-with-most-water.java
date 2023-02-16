class Solution {
    public int maxArea(int[] height) {
        int area = 0, max = 0;
        int i=0, j=height.length-1, h;
        
        while(i<j){
            h = Math.min(height[i], height[j]);
            
            area = (j-i)*h;
            
            max = Math.max(max, area);
            
            while(height[i]<=h && i<j) i++;
            while(height[j]<=h && i<j) j--;
        }
        
        return max;
    }
}