class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int curr=0, sum=0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int ind=0; ind<nums.length; ind++){
            if(nums[ind]%2==0){
                sum += nums[ind];
                set.add(ind);
            }
        }
        
        for(int[] ind : queries){
            if(set.contains(ind[1])){
                sum -= nums[ind[1]];
                set.remove(ind[1]);
            }
            
            nums[ind[1]] = nums[ind[1]]+ind[0];
            
            if(nums[ind[1]]%2==0){
                sum += nums[ind[1]];
                set.add(ind[1]);
            }
            
            ans[curr++] = sum;
        }
        
        return ans;
    }
}