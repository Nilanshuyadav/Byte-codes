class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int k=0,cnt=0;
        
        for(int ind=0; ind<n; ind++){
            if(nums[ind]==0) cnt++;
            else nums[k++] = nums[ind];
        }
        
        for(int ind=n-cnt; ind<n; ind++)
            nums[ind] = 0;
        
    }
}