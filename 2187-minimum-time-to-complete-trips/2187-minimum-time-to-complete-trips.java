class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l=0, h=(long)1e14, m, temp;
        
        while(l<h){
            m = l+(h-l)/2;
            
            temp = solve(m, time);
            
            if(temp>=totalTrips) h=m;
            else l = m+1;
        }
        
        return l;
    }
    
    public long solve(long time, int[] time_arr){
        long cnt=0;
        
        for(int ind=0; ind<time_arr.length; ind++)
            cnt += time/time_arr[ind];
        
        return cnt;
    }
}