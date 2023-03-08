class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, high=1000000000, m;
        long temp;
        
        while(l<high){
            m = l + (high-l)/2;
            
            temp = solve(m, piles);
            
            if(temp<=h) high = m;
            else l = m+1;
        }
        
        return l;
    }
    
    public long solve(int n, int[] piles){
        long cnt=0;
        
        for(int ind : piles){
            cnt += ind%n==0 ? ind/n : (ind/n)+1;
        }
        
        return cnt;
    }
}