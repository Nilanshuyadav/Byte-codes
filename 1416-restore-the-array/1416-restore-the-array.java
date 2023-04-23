class Solution {
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        
        return solve(0, s, k, dp);
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