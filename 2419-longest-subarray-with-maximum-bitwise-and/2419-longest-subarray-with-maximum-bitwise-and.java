class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, max=0;
        
        for(int i : nums){
            max = Math.max(max, i);
        }
        
        int cnt=0, ans=0;
        for(int i : nums){
            if(i==max){
                cnt++;
            }
            else{
                ans = Math.max(ans, cnt);
                cnt=0;
            }
        }
        
        ans = Math.max(ans, cnt);
        return ans;
    }
}