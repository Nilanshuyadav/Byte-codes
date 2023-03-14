class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int cnt=0, n=nums.length, i=0, j=(n+1)/2;
        
        while(j<n){
            if(2*nums[i] <= nums[j]){
                cnt+=2;
                
                i++;
            }
            
            j++;
        }
        
        return cnt;
    }
}