class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum=0;
        
        for(int ind : batteries){
            sum += ind;
        }
        
        long l=1, h=sum/n, m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(canWe(batteries, n, m)){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return h;
    }
    
    public boolean canWe(int[] batteries, int n, long m){
        long sum=0;
        
        for(int ind : batteries){
            if(ind<=m){
                sum += ind;
            }
            else{
                sum += m;
            }
        }
        
        return(sum/m) >= n;
    }
}