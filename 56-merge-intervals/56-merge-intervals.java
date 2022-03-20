class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        List<int[]> ans = new ArrayList<>();
        
        int low = intervals[0][0];
        int high = intervals[0][1];
        
        for(int[] i:intervals){
            if(i[0]<=high){
                high = Math.max(i[1],high);
            }
            else{
                
                ans.add(new int[]{low,high});
                low = i[0];
                high = i[1];
            }
        }
        
        ans.add(new int[]{low,high});
        
        return ans.toArray(new int[0][]);
    }
}