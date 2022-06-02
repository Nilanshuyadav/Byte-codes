class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index1 = -1,index2 = -1;;
        int high,low,temp;
        
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index1 = i-1;
                break;
            }
        }
        
        if(index1 == -1){
            high = n-1;
            low = 0;
            while(low<=high){
                temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
            return;
        }
        
        for(int i =n-1;i>=0;i--){
            if(nums[i]>nums[index1]){
                index2 = i;
                break;
            }
        }
        
        temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        
        high = n-1;
        low = index1+1;
        
        while(low<=high){
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
        
    }
}