class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int mark1 = -1;
        
        for(int i=n-1;i>0;i--){
            if(nums[i] > nums[i-1]) {mark1 = i-1; break;}
        }
        
        if(mark1 == -1)  {reverse(0,n-1,nums); return;}
        
        for(int i=n-1;i>=0;i--){
            if(nums[i] > nums[mark1]) {
                int temp = nums[i];
                nums[i] = nums[mark1];
                nums[mark1] = temp;
                break;
            }
        }
        
        reverse(mark1+1,n-1,nums);
    }
    
    private void reverse(int low, int high, int[] nums){
        int temp;
        while(low < high){
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}