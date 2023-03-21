class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        long cnt=0;
        
        for(int ind=0; ind<nums.length; ind++){
            if(nums[ind] == 0){
                cnt++;
            }    
            else{
                ans += ((cnt * (cnt+1)) / 2);
                cnt=0;
            }
        }
        
        if(cnt>0){
            ans += ((cnt * (cnt+1)) / 2);
        }
        
        return ans;
    }
}