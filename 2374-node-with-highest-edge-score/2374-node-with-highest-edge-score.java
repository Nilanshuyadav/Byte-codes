class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] arr = new long[n];
        
        for(int ind=0; ind<n; ind++)
            arr[edges[ind]] += ind;
        
        long max = -1, ans = -1;
        for(int ind=0; ind<n; ind++){
            if(arr[ind] > max){
                max = arr[ind];
                ans = ind;
            }
        }
        
        return (int)ans;
    }
}