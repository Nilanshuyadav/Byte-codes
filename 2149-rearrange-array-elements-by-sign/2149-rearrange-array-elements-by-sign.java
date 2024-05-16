class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int i=0, j=1;
        
        for(int ind=0; ind<n; ind++){
            if(nums[ind] < 0){
                arr[j] = nums[ind];
                j += 2;
            }
            else{
                arr[i] = nums[ind];
                i += 2;
            }
        }
        
        return arr;
    }
}