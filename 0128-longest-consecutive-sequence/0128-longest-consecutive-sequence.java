class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        
        if(n==0 || n==1)    return n;
        
        Arrays.sort(nums);
        
        int max = 1, curr=1, pre = nums[0];
        
        for(int ind=1; ind<n; ind++){
            if(pre == nums[ind]) continue;
            
            if(pre+1 == nums[ind]){
                curr++;
            }
            else{
                curr = 1;
            }
            
            pre = nums[ind];
            max = Math.max(max, curr);
        }
        
        return max;
    }
}