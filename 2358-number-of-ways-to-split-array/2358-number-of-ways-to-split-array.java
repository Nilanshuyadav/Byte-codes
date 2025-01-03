class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0, total=0;
        int cnt=0, n = nums.length, i;

        for(int in : nums){
            total += in;
        }

        for(int in=0; in<n-1; in++){
            i = nums[in];
            sum += i;

            if(sum >= total-sum) cnt++;
        }

        return cnt;
    }
}