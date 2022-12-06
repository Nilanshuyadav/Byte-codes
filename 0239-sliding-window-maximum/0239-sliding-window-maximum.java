class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        
        int max = 0, curr = 0;
        for(int ind=0; ind<n; ind++){
            if(ind < k-1){
                if(nums[max] <= nums[ind])
                    max = ind;
            }
            else{
                
                if(nums[max] <= nums[ind])
                    max = ind;
                
                if(ind-k+1 > max){
                    max = ind-k+1;
                    
                    for(int inx=ind-k+1; inx<=ind; inx++)
                        if(nums[max] <= nums[inx])
                            max = inx;
                }
                
                result[ind-k+1] = nums[max];
            }
        }
        
        return result;
    }
}