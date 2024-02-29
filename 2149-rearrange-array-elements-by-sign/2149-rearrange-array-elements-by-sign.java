class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length, p=0, n=1, ans[] = new int[len];
        
        for(int ind=0; ind<len; ind++){
            if(nums[ind]>=0){
                ans[p] = nums[ind];
                p += 2;
            }
            else{
                ans[n] = nums[ind];
                n += 2;
            }
        }
        
        return ans;
    }
}