class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> a[0]>b[0]? 1:-1);
        
        int cnt=0, n = points.length, end=points[0][1];
        for(int ind=1; ind<n; ind++){
            if(points[ind][0] > end){
                cnt++;
                end = points[ind][1];
            }
            
            end = Math.min(end, points[ind][1]);
        }
        
        return cnt+1;
    }
}