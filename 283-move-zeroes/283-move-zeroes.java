class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int k=-1;
        
        for(int ind=0; ind<n; ind++){
            if(k==-1 && nums[ind]==0){
                k=ind;
                continue;
            }
            if(k!=-1 && nums[ind]!=0){
                int temp = nums[k];
                nums[k++] = nums[ind];
                nums[ind] = temp;
            }
        }
    }
}