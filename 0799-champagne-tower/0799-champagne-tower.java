class Solution {
    double total;
    public double champagneTower(int poured, int query_row, int query_glass) {
        total = poured;
        
        double[][] dp = new double[100][100];
        
        for(double[] ind : dp)
            Arrays.fill(ind, -1);
        
        double temp = solve(query_row, query_glass, dp);
        
        return temp>1 ? 1.0 : temp;
    }
    
    public double solve(int row, int col, double[][] dp){
        if(row == 0){
            return total;
        }
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        if(col==0){
            double temp1 = Math.max(1, solve(row-1, col, dp));
            
            return dp[row][col] = (temp1-1)/2;
        }
        else if(col == row){
            double temp2 = Math.max(1, solve(row-1, col-1, dp));
            
            return dp[row][col] = (temp2-1)/2;
        }
        else{
            double temp1 = Math.max(1, solve(row-1, col-1, dp)),
                    temp2 = Math.max(1, solve(row-1, col, dp));
            
            return dp[row][col] = (temp1 + temp2 - 2)/2;
        }    
    }
}