class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count=-1;
        int end = intervals[0][1];
        
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        
        for(int[] i:intervals){
            if(i[0]<end){
                count++;
                end = Math.min(end,i[1]);
            }
            else{
                end = i[1];
            }
        }
        return count;
    }
}