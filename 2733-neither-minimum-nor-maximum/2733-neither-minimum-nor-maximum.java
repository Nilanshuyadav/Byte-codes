class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        
        if(n<=2){
            return -1;
        }
        
        int max=0, min=n-1, max_f=0, min_f=0, ans=-1;
        
        for(int ind=0; ind<n; ind++){
            if(nums[ind]>nums[max]){
                max = ind;
            }
            
            if(nums[ind]<nums[min]){
                min = ind;
            }
        }
        
        if(min+1<n && min+1!=max){
            return nums[min+1];
        }
        else if(min-1>=0 && min-1!=max){
            return nums[min-1];
        }
        
        return max+1!=min ? nums[max+1] : nums[max-1];
    }
}