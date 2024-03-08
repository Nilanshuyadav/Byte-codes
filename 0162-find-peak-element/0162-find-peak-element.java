class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(m==n-1 || (nums[m]>nums[m+1])){
                if(m==0 || (nums[m-1]<nums[m])) return m;
                else h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return -1;
    }
}