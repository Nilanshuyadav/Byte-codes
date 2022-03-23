class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] helper = new int[n]; 
        helper[0] = 1;
        
        for(int i=0;i<n-1;i++)
            helper[i+1] = helper[i]*nums[i];
        
        int product = 1;
        
        for(int i=n-1;i>0;i--){
            product= product*nums[i];
            helper[i-1] = helper[i-1] * product;
        }
        
        return helper;
    }
}