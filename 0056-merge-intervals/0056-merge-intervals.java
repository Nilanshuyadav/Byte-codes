class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int start=intervals[0][0], end=intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        
        for(int ind[] : intervals){
            if(end < ind[0]){
                ans.add(new int[]{start, end});
                
                start = ind[0];
            }
            
            end = Math.max(end, ind[1]);
        }
        
        ans.add(new int[]{start, end});
        
        return ans.toArray(new int[0][]);
    }
}