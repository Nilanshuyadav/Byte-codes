class Solution {
    int[][][] dp;
    long mod = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startCol) {
        dp = new int[m+1][n+1][maxMove+1];
        
        for(int[][] i:dp) for(int[] j:i)Arrays.fill(j,-1);
       
        return  (int)(helper(m,n,startRow,startCol,maxMove) % mod);
    }
    
    public long helper(int m,int n, int startRow,int startCol,int maxMove){
        
        if(startRow<0 || startRow>=m || startCol<0 || startCol>=n) return 1;
        
        if(maxMove <= 0) return 0;
        
        if(dp[startRow][startCol][maxMove] != -1) return dp[startRow][startCol][maxMove];
        
        long sum = 0;
        
        sum += helper(m,n,startRow+1,startCol,maxMove-1);
        sum += helper(m,n,startRow-1,startCol,maxMove-1);
        sum += helper(m,n,startRow,startCol+1,maxMove-1);
        sum += helper(m,n,startRow,startCol-1,maxMove-1);
        
        return dp[startRow][startCol][maxMove] = (int)(sum%mod);
    }
}