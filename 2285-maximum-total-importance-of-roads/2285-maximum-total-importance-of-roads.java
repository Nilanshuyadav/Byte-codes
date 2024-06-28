class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        
        for(int i[] : roads){
            degree[i[0]]++;
            degree[i[1]]++;
        }
        
        Arrays.sort(degree);
        
        long sum=0;
        
        for(int i=n-1; i>=0; i--){
            sum += (degree[i]*(i+1));
        }
        
        return sum;
    }
}