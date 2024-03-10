class Solution {
    public int splitArray(int[] nums, int k) {
        int max=0, sum=0;
        
        for(int i : nums){
            max = Math.max(max, i);
            sum += i;
        }
        
        int l=max, h=sum, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(canWe(nums, m, k)){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return h+1;
    }
    
    public boolean canWe(int[] nums, int m, int k){
        int sum = 0, cnt=1;
        
        for(int i : nums){
            sum += i;
            
            if(sum > m){
                cnt++;
                sum = i;
            }
        }
        
        return cnt>k;
    }
}