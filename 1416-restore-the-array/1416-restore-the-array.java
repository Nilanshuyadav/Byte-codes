class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n+1];
        
        dp[n] = 1;
        long sum;
        StringBuilder sb;
        for(int ind=n-1; ind>=0; ind--){
            sum = 0;
            sb = new StringBuilder("");
            
            for(int inx=ind; inx<n; inx++){
                sb.append(s.charAt(inx));
                
                if(!isValid(sb.toString(), k)){
                    break;
                }
                
                sum = (sum + dp[inx+1])%1000000007;
            }
            
            dp[ind] = (int)sum;
        }
        
        return dp[0];
    }
    
    public int solve(int ind, String s, int k, int[] dp){
        if(ind == s.length()){
            return 1;
        }
        
        if(s.charAt(ind) == 0){
            return 0;
        }
        
        if(dp[ind] != -1) {return dp[ind];} 
        
        StringBuilder sb = new StringBuilder("");
        
        long sum=0;
        
        for(int inx=ind; inx<s.length(); inx++){
            sb.append(s.charAt(inx));
            
            if(!isValid(sb.toString(), k)){
                return dp[ind] = (int)sum;
            }
            
            sum = (sum + solve(inx+1, s, k, dp))%1000000007;
        }
        
        return dp[ind] = (int)sum;
    }
    
    public boolean isValid(String st, int k){
        long num = Long.valueOf(st);
        
        if(num<1 || num>k) return false;
        return true;
    }
}