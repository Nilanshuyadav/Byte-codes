class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index1 = -1;
        
        for(int ind=n-1; ind>0; ind--){
            if(nums[ind-1]<nums[ind]){
                index1 = ind-1;
                break;
            }
        }
        
        if(index1 == -1){
            reverse(nums, 0, n-1);
            return;
        }
        
        int index2=-1;
        
        for(int ind=n-1; ind>index1; ind--){
            if(nums[index1]<nums[ind]){
                swap(nums, index1, ind);
                reverse(nums, index1+1, n-1);
                break;
            }
        }
    }
    
    public void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}