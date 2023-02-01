class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        
        if(k==0){
            return n>0?nums[0]:-1;
        }
        
        if(k==1){
            if(n==1)
                return -1;
            return nums[1];
        } 
        
        if(n==1){
            if(k%2==0)
                return nums[0];
            else
                return -1;
        }
        
        int ind, max=0;
        
        for(ind=0; ind<Math.min(n,k-1); ind++)
            max = Math.max(max, nums[ind]);
        
        if(ind>=n-1)
            return max;
        return Math.max(max,nums[ind+1]);
    }
}