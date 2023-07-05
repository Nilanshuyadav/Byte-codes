class Solution {
    public int longestSubarray(int[] nums) {
        int i=0, j=0, n=nums.length;
        
        while(j<n && nums[j] != 0){
            j++;
        }
        
        if(j==n){
            return n-1;
        }
        
        int ind=j+1, ans=0;
        
        while(ind<n){
            if(nums[ind] == 0){
                ans = Math.max(ans, ind-i-1);
                
                i=j+1;
                j=ind;
            }
            
            ind++;
        }
        
        ans = Math.max(ans, ind-i-1);
        
        return ans;
    }
}