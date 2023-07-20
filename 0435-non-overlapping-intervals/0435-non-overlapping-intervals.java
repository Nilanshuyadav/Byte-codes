class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        
        Arrays.sort(intervals, (a,b) -> a[0]!=b[0]? a[0]-b[0] : a[1]-b[1]);
        
        int cnt=0, ind=0, end=-(int)1e8;
        
        while(ind<n){
            if(intervals[ind][0] < end){
                cnt++;
                end = Math.min(end, intervals[ind][1]);
            }
            else{
                end = intervals[ind][1];
            }
            
            ind++;
        }
        
        return cnt;
    }
}