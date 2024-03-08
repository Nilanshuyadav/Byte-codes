class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = 0, n = bloomDay.length;
        long pro = (long)m*k;
        
        if(pro>n) return -1;
        
        for(int i : bloomDay){
            max = Math.max(max, i);
        }
        
        int l=1, h=max, mid;
        
        while(l<=h){
            mid = l + (h-l)/2;
            
            if(canWe(bloomDay, mid, m, k)) h = mid-1;
            else l = mid+1;
        }
        
        return h+1;
    }
    
    public boolean canWe(int[] bloomDay, int mid, int m, int k){
        int cnt=0, temp_cnt=0;
        
        for(int i : bloomDay){
            if(i <= mid){
                temp_cnt++;
            }
            else{
                cnt += (temp_cnt/k);
                temp_cnt=0;
            }
        }
        
        cnt += (temp_cnt/k);
        
        return cnt>=m;
    }
}