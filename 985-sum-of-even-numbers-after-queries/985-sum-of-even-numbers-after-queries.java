class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int curr=0, sum=0;
        
        for(int ind=0; ind<nums.length; ind++){
            if(nums[ind]%2==0){
                sum += nums[ind];
            }
        }
        
        for(int[] ind : queries){
            if(nums[ind[1]]%2==0){
                sum -= nums[ind[1]];
            }
            
            nums[ind[1]] = nums[ind[1]]+ind[0];
            
            if(nums[ind[1]]%2==0){
                sum += nums[ind[1]];
            }
            
            ans[curr++] = sum;
        }
        
        return ans;
    }
}