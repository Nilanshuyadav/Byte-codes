class Solution {
    public int smallestDivisor(int[] nums, int th) {
        int l=1, h=0, m, max = 0;
        
        for(int i : nums) max = Math.max(max, i);
        h = max+1;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(canWe(nums, m, th)) h = m-1;
            else l = m+1;
        }
        
        return h+1;
    }
    
    public boolean canWe(int[] arr, int m, int th){
        long sum = 0;
        
        for(int i : arr){
            sum += (i+m-1)/m;
        }
        
        return sum<=th;
    }
}