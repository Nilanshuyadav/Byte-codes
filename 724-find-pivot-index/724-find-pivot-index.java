class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, suff[] = new int[n];
        int total = 0;
        
        for(int ind=0; ind<n; ind++){
            if(ind!=0)suff[ind] = suff[ind-1] + nums[ind-1];
            total += nums[ind];
        }
        
        for(int ind=0; ind<n; ind++){
            if((total-nums[ind])%2!=0) continue;
            
            else{
                int half = (total-nums[ind])/2;
                if(half == suff[ind]) return ind;
            }
        }
        
        return -1;
    }
}