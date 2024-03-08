class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        int max=0, ans=0;
        
        for(int i : nums){
            arr[i]++;
            
            if(arr[i] == max) ans += arr[i];
            else if(arr[i] > max){
                max = arr[i];
                ans = max;
            }
            
        }
        
        return ans;
    }
}