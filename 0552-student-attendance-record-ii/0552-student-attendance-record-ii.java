class Solution {
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        
        for(int A=0; A<2; A++){
            for(int L=0; L<3; L++){
                dp[0][A][L] = 1;
            }
        }
        
        long sum = 0;
        
        for(int ind=1; ind<=n; ind++){
            for(int A=0; A<2; A++){
                for(int L=0; L<3; L++){
                    sum = 0;
                    
                    if(A>0){
                        sum += dp[ind-1][A-1][2];
                    }   
                    if(L>0){
                        sum += dp[ind-1][A][L-1];
                    }
                    
                    sum += dp[ind-1][A][2];
                    
                    dp[ind][A][L] = (int)(sum%1000000007);
                }
            }
        }
        
        return dp[n][1][2];
    }
}