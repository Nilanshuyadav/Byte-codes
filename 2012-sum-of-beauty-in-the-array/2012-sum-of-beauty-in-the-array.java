class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        
        right[n-1] = (int)1e8;
        int max=0;
        
        for(int ind=n-2; ind>=0; ind--){
            right[ind] = Math.min(right[ind+1], nums[ind+1]);
        }
        
        int ans=0;
        for(int ind=0; ind<n-1; ind++){
            if(ind == 0){                
                max = nums[0];
            }
            else{
                if(max < nums[ind] && nums[ind] < right[ind]){
                    ans += 2;
                }
                else if(nums[ind-1] < nums[ind] && nums[ind]<nums[ind+1]){
                    ans += 1;
                }
                
                max = Math.max(max, nums[ind]);
            }
        }
        
        return ans;
    }
}