class Solution {
    public int maxScore(int[] nums) {
        
        Arrays.sort(nums);
        
        long sum=0;
        int cnt=0;
        
        for(int ind=nums.length-1; ind>=0; ind--){
            sum += nums[ind];
            
            if(sum <= 0)
                return cnt;
            
            cnt++;
        }
        
        return cnt;
    }
}