class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max=-(int)1e8, total=0;
        int ind=0, n=nums.length;
        
        while(ind < n){
            if(ind < k-1){
                total += nums[ind];
            }
            else{
                total += nums[ind];
                
                max = Math.max(max, total/k);
                
                total -= nums[ind-k+1];
            }
            
            ind++;
        }
        
        return max;
    }
}