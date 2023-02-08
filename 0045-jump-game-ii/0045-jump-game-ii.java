class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int ind=0, max=0, n = nums.length, temp_max;
        
        if(n==1)
            return 0;
        
        while(ind<n){
            jump++;
            temp_max = max;
            while(ind<=temp_max){
                max = Math.max(max, ind+nums[ind]);
                ind++;
            }
            
            if(max>=n-1)
                return jump;
        }
        
        return -1;
    }
}