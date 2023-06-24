class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        
        if(n==2){
            return 1;
        }
        
        int[] left = new int[n];
        
        left[n-1] = (int)1e8;
        for(int ind=n-2; ind>=0; ind--){
            left[ind] = Math.min(left[ind+1], nums[ind+1]);
        }
        
        int max=nums[0];
        
        for(int ind=0; ind<n; ind++){
            max = Math.max(max, nums[ind]);
            
            if(max <= left[ind]){
                return ind+1;
            }
        }
        
        return -1;
    }
}