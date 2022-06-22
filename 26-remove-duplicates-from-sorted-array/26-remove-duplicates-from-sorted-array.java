class Solution {
    public int removeDuplicates(int[] nums) {
       int value = nums[0];
        int n = nums.length,k=1;
        
        for(int i=1;i<n;i++){
            if(nums[i] != value){
                nums[k] = nums[i];
                value = nums[i];
                k++;
            }
        }
        
        return k;
    }
}