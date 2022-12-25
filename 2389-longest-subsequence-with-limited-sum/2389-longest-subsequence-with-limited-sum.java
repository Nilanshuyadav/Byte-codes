class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = queries.length, m = nums.length;
        
        int[] ans = new int[n];
        
        Arrays.sort(nums);
        
        for(int ind=0; ind<n; ind++){
            int inx = 0, sum = 0;
            
            for(inx=0; inx<m; inx++){
                sum += nums[inx];
                
                if(sum > queries[ind])
                    break;
            }
            
            ans[ind] = inx;
        }
        
        return ans;
    }
}