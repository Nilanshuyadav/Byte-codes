class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        
        List<int[]> al = new ArrayList<>();
        int ind=0, start = 0, end = 0;
        
        for(ind=0; ind<n; ind++){
            if(newInterval[0] < intervals[ind][0]){
                if(ind==0){
                    start = newInterval[0];
                }
                else if(newInterval[0]<=intervals[ind-1][1]){
                    start = intervals[ind-1][0];
                    ind--;
                }
                else{
                    start = newInterval[0];
                }
                
                break;
            }
            else if(newInterval[0] > intervals[ind][1])
                al.add(intervals[ind]);
        }
        
        if(ind==n){
            if(n==0)
                al.add(newInterval);
            else if(intervals[n-1][1] < newInterval[0]){
                al.add(newInterval);
            }
            else
                al.add(new int[]{intervals[n-1][0], Math.max(intervals[n-1][1], newInterval[1])});
            
            int[][] ans = new int[al.size()][2];
            int k=0;

            for(int inx[] : al){
                ans[k++] = inx;
            }

            return ans;
        }
        
        while(ind<=n){
            if(ind == n){
                end = newInterval[1];
            }
            else if(newInterval[1] < intervals[ind][1]){
                if(newInterval[1] < intervals[ind][0])
                    end = newInterval[1];
                else
                    end = intervals[ind++][1];
                
                break;
            }
            
            ind++;
        }
        
        al.add(new int[]{start, end});
        
        while(ind<n)
            al.add(intervals[ind++]);
        
        int[][] ans = new int[al.size()][2];
        int k=0;
        
        for(int inx[] : al){
            ans[k++] = inx;
        }
        
        return ans;
        
    }
}