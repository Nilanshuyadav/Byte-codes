class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        
        for(int ind[] : dp)
            Arrays.fill(ind, -1);
        
        return solve(word1.length()-1, word2.length()-1, word1, word2, dp);
    }
    
    public int solve(int i, int j, String s1, String s2, int[][] dp){
        if(i==-1 || j==-1){
            if(i==-1 && j==-1)
                return 0;
            if(i==-1)
                return j+1;
            else
                return i+1;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        char ch_i = s1.charAt(i), ch_j = s2.charAt(j);
        int insert = (int)1e8, delete=(int)1e8, replace=(int)1e8;
        
        if(ch_i == ch_j){
            return dp[i][j] = solve(i-1, j-1, s1, s2, dp);
        }
        else{
            insert = 1 + solve(i, j-1, s1, s2, dp);
            delete = 1 + solve(i-1, j, s1, s2, dp);
            replace = 1 + solve(i-1, j-1, s1, s2, dp);
        }
        
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}