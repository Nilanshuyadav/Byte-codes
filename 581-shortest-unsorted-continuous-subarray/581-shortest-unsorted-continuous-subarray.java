class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;
        int low=0 , high = n-1;
        
        
        while(low < n-1 && nums[low] <= nums[low+1]) low++;
        while(high > 0 && nums[high] >= nums[high-1]) high--;
        
        if(low == n-1) return 0;
        
        int smin = Integer.MAX_VALUE , smax = Integer.MIN_VALUE;
        for(int i= low; i<high+1; i++)
        {
            smin = Math.min(smin,nums[i]);
            smax = Math.max(smax,nums[i]);
        }
        
        while(low>0 && nums[low-1]>smin) low--;
        while(high<n-1 && nums[high+1]<smax) high++;
        
        return high-low+1;
    }
}