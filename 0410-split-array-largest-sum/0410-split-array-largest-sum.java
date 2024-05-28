class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        
        for(int i : nums){
            sum += i;
        }
        
        int l=0, h=sum, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(canWe(nums, m, k)){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return h+1;
    }
    
    public boolean canWe(int[] nums, int m, int k){
        int sum=0, cnt=0;
        
        for(int i : nums){
            if(i>m) return false;
            
            sum += i;
            
            if(sum > m){
                cnt++;
                sum = i;
            }
        }
        
        cnt++;
        
        return cnt<=k;
    }
}