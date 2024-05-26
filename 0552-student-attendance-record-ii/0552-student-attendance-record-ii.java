class Solution {
    public int checkRecord(int n) {
        int[][] dp = new int[2][3];
        int[][] curr = new int[2][3];
        
        for(int A=0; A<2; A++){
            for(int L=0; L<3; L++){
                dp[A][L] = 1;
            }
        }
        
        long sum = 0;
        
        for(int ind=1; ind<=n; ind++){
            for(int A=0; A<2; A++){
                for(int L=0; L<3; L++){
                    sum = 0;
                    
                    if(A>0){
                        sum += dp[A-1][2];
                    }   
                    if(L>0){
                        sum += dp[A][L-1];
                    }
                    
                    sum += dp[A][2];
                    
                    curr[A][L] = (int)(sum%1000000007);
                }
            }
            
            for(int A=0; A<2; A++){
                for(int L=0; L<3; L++){
                    dp[A][L] = curr[A][L];
                }
            }
        }
        
        return dp[1][2];
    }
}