class Solution {
    public int[][] generateMatrix(int n) {
        int val = 1;
        int r1 = 0,r2 = n-1;
        int c1 = 0,c2 = n-1;
        
        int[][] ans = new int[n][n];
        
        while(r1<=r2 && c1<=c2){
            for(int i=c1;i<=c2;i++)
                ans[r1][i] = val++;
            
            for(int i = r1+1;i<r2;i++)
                ans[i][c2] = val++;
            
            for(int i=c2;i>c1;i--)
                ans[r2][i] = val++;
            
            for(int i=r2;i>r1;i--)
                ans[i][c1] = val++;
            
            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        return ans;
    }
}