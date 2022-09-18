class Solution {
    public int trap(int[] height) {
        int l = 1, r = height.length-2;
        int left_max = height[0], right_max = height[height.length-1];
        int sum = 0;
        
        while(l<=r){
            
            if(left_max<=right_max){
                if(height[l]>=left_max) left_max = height[l];
                else sum += left_max-height[l];
                l++;
            }
            else{
                if(height[r]>=right_max) right_max = height[r];
                else sum += right_max-height[r];
                r--;
            }
        }
        
        return sum;
    }
}