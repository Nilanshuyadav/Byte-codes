class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int max_reach = 0;
        int step = 0;
        int reach = 0;
        
        for(int i=0;i<n;i++){
            if(i > reach) {step++; reach = max_reach;}
            max_reach = Math.max(max_reach,i+nums[i]);
        }
        return step;
    }
}