class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        
        int k=0, i=0, j=n;
        
        while(j<(2*n)){
            if(k%2==0){
                ans[k++] = nums[i++];
            }
            else{
                ans[k++] = nums[j++];
            }
        }
        
        return ans;
    }
}