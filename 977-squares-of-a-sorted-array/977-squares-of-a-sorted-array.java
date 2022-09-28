class Solution {
    public int[] sortedSquares(int[] nums) {
        int ind=0;
        while(ind<nums.length && nums[ind] < 0) ind++;
        
        int[] ans = new int[nums.length];
        int k=0;
        
        int i=ind-1, j = ind;
        
        while(i>=0 && j<nums.length){
            if(j<nums.length && Math.abs(nums[i])<Math.abs(nums[j])) ans[k++] = (int)(nums[i]*nums[i--]);
            else ans[k++] = (int)(nums[j]*nums[j++]);
        }
        
        while(i>=0) ans[k++] = (int)(nums[i]*nums[i--]);
        while(j<nums.length) ans[k++] = (int)(nums[j]*nums[j++]);
        
        return ans;
        
    }
}