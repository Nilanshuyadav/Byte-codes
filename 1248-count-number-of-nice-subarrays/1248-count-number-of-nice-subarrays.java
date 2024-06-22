class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        
        int[] arr = new int[n+1];
        
        arr[0] = 1;
        int sum = 0, cnt=0;
        
        for(int i=0; i<n; i++){
            sum += nums[i]&1;
            
            if(sum>=k)
                cnt += arr[sum-k];
            
            arr[sum]++;
        }
        
        return cnt;
    }
}