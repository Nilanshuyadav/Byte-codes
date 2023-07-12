class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        int temp = s.charAt(0)!='0' ? solve(0, s, new StringBuilder(""), n, dp) : -1;
        
        return temp!=(int)1e8 ? temp : -1;
        
    }
    
    public int solve(int ind, String s, StringBuilder sb, int n, int[] dp){
        if(ind == n){
            return 0;
        }
        
        if(dp[ind] != -1){
            return dp[ind];
        }
        
        int min=(int)1e8;
        for(int i=ind; i<n; i++){
            sb.append(s.charAt(i));
            
            if((i==n-1 || s.charAt(i+1)!='0') && canWe(sb)){
                min = Math.min(min, solve(i+1, s, new StringBuilder(""), n, dp)+1);
            }
        }
        
        return dp[ind] = min;
    }
    
    public boolean canWe(StringBuilder sb){
        long num = Long.parseLong(sb.toString(), 2);
        
        String st = Long.toString(num, 5);
        
        return countSetBits(st) == 1;
    }
    
    public int countSetBits(String st){
        int n = st.length(), cnt=0;
        
        for(int ind=0; ind<n; ind++){
            cnt+= st.charAt(ind)-'0';
        }
        
        return cnt;
    }
}