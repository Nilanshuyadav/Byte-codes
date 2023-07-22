class Solution {
    int[] r_arr={-2,-2,-1,1,2,2,1,-1}, c_arr={-1,1,2,2,1,-1,-2,-2};
    
    public double knightProbability(int n, int k, int row, int col) {
        double[][][] dp = new double[n][n][k+1];
        
        for(double[][] i : dp){
            for(double[] j : i){
                Arrays.fill(j, -1);
            }
        }
        
        return solve(n, k, row, col, dp);
    }
    
    public double solve(int n, int k, int row, int col, double[][][] dp){
        if(k==0){
            return 1;
        }
        
        if(dp[row][col][k] != -1){
            return dp[row][col][k];
        }
        
        double temp=0;
        int new_r, new_c;
        
        for(int i=0; i<8; i++){
            new_r = row+r_arr[i];
            new_c = col+c_arr[i];
            
            if(new_r<0 || new_c<0 || new_r>=n || new_c>=n){
                continue;
            }
            
            temp += (0.125)*solve(n, k-1, new_r, new_c, dp);
        }
        
        return dp[row][col][k] = temp;
    }
}