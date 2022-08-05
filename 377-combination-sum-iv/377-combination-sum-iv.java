class Solution {
    int count;
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        count = 0;
        
        int[] memo = new int[target+1];
        Arrays.fill(memo,-1);
        
        count = function(nums,n,target,0, memo);
        
        return count;
    }
    
    public int function(int[] nums,int n, int target, int ind, int[] memo){
        if(target == 0){
            count++;
            return 1;
        }
        else if(memo[target] != -1) return memo[target];
        
        int ans = 0;
        
        for(int i =0;i<n;i++){
            if(target-nums[i] >= 0){
                ans += function(nums,n,target-nums[i],i,memo);
            }
        }
        
        return memo[target] = ans;
    }
}