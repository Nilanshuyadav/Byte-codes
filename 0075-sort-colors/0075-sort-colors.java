class Solution {
    public void sortColors(int[] nums) {
        int l=0, h=nums.length-1;
        
        for(int ind=0; ind<=h; ind++){
            if(nums[ind] == 0){
                swap(nums, l++, ind);
            }
            else if(nums[ind] == 2){
                swap(nums, h--, ind--);
            }
        }
    }
    
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        
        arr[i] = arr[j];
        arr[j] = temp;
    }
}