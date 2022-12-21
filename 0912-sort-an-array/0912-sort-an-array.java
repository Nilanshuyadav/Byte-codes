class Solution {
    public int[] sortArray(int[] nums) {
        mergeBreak(0, nums.length-1, nums);
        
        return nums;
    }
    
    public void mergeBreak(int start, int end, int[] nums){
        if(start<end){
            int mid = start + (end-start)/2;
            
            mergeBreak(start, mid, nums);
            mergeBreak(mid+1, end, nums);
            
            merge(start, mid, end, nums);
        }
    }
    
    public void merge(int start, int mid, int end, int[] nums){
        int len = end-start+1;
        
        int[] temp = new int[len];
        
        int k=0,i=start, j=mid+1;
        
        while(i<=mid && j<=end){
            if(nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        
        while(i<=mid)
            temp[k++] = nums[i++];
        
        while(j<=end)
            temp[k++] = nums[j++];
        
        for(k=0; k<len; k++){
            nums[start+k] = temp[k];
        }
    }
}