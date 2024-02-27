class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, k=1;
        
        for(int ind=1; ind<n; ind++){
            if(nums[ind-1]!=nums[ind]){
                nums[k] = nums[ind];
                k++;
            }
        }
        
        return k;
    }
}