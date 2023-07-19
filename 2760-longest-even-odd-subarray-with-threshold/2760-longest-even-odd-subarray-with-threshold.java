class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l=0, r=0, max=0, n=nums.length;
        
        while(r<n){
            while(l<n && ((nums[l]&1)!=0 || nums[l]>threshold)){
                l++;
            }
            
            if(l==n) break;
            
            r=l;
            
            while(r<n-1 && (nums[r]&1) != (nums[r+1]&1) && nums[r+1]<=threshold){
                r++;
            }
            
            max = Math.max(max, r-l+1);
            l=r+1;
        }
        
        return max;
    }
}