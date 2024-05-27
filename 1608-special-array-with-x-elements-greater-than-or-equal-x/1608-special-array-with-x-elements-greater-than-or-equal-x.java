class Solution {
    public int specialArray(int[] nums) {
        int n=nums.length;
        
        int l=0, h=n;
        
        int m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            int cnt = 0;
            
            for(int i : nums){
                if(i>=m){
                    cnt++;
                }
            }
            
            
            if(cnt == m){
                return m;
            }
            else if(cnt < m){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return -1;
    }
}