class Solution {
    public void sortColors(int[] nums) {
        int high = nums.length -1;
        int low = 0;
        int n = high + 1;
        int temp;
        int i =0;
        
        while(i<=high){
            if(nums[i] == 0){
                temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
            }
            
            else if(nums[i] == 2){
                temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
                i--;
            }
            i++;
        }
    }
}