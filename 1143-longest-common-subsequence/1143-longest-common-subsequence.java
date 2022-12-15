class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();

        int[] dp = new int[n2], curr;

        for(int r=0; r<n1; r++){
            curr = new int[n2];
            for(int c=0; c<n2; c++){
                if(text1.charAt(r) == text2.charAt(c)){
                    curr[c] = c==0?1:1+dp[c-1];
                }
                else{
                    curr[c] = c==0?dp[c]:Math.max(curr[c-1], dp[c]);
                }
            }

            dp = curr;
        }
        return dp[n2-1];
    }
}