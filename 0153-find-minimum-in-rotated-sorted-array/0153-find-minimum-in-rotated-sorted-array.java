class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l=0, r=n-1, m;

        while(l<=r){
            m = l + (r-l)/2;

            if(m>0 && nums[m-1]>nums[m]) return nums[m];
            else if(m<n-1 && nums[m]>nums[m+1]) return nums[m+1];
            else if(nums[l]<nums[m]) l = m+1;
            else r = m-1;
        }

        return nums[0];
    }
}