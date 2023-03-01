class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        
        mergebreak(0, n-1, nums);
        
        return nums;
    }
    
    public void mergebreak(int l, int h, int[] nums){
        if(l<h){
            int m = l+(h-l)/2;
            
            mergebreak(l, m, nums);
            mergebreak(m+1, h, nums);
            
            merge(l, m, h, nums);
        }
    }
    
    public void merge(int l, int m, int h, int[] nums){
        int i=l, j=m+1, k=0, n = h-l+1;
        int[] arr = new int[n];
        
        while(i<=m && j<=h){
            if(nums[i]<nums[j]) arr[k++] = nums[i++];
            else arr[k++] = nums[j++];
        }
        
        while(i<=m) arr[k++] = nums[i++];
        while(j<=h) arr[k++] = nums[j++];
        
        for(int ind=l; ind<=h; ind++){
            nums[ind] = arr[ind-l];
        }
    }
}