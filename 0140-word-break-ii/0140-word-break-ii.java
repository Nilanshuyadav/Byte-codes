class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        int n = s.length();
        List<String>[] dp = new ArrayList[n];
        
        List<String> ans = solve(0, s.length(), s, "", new HashSet<>(wordDict), dp);
        
        for(int ind=0; ind<ans.size(); ind++){
            ans.set(ind, ans.get(ind).substring(1));
        }
        
        return ans;
    }
    
    public List<String> solve(int ind, int n, String s, String temp, Set<String> set, List<String>[] dp){
        if(ind == n){
            return new ArrayList<>(Arrays.asList(""));
        }
        
        if(dp[ind] != null){
            return dp[ind];
        }
        
        StringBuilder sb = new StringBuilder("");
        char ch;
        
        List<String> toReturn = new ArrayList<>();
        
        for(int i=ind; i<n; i++){
            ch = s.charAt(i);
            
            sb.append(ch);
            
            if(set.contains(sb.toString())){
                List<String> returned = solve(i+1, n, s, temp+" "+sb, set, dp);
                
                if(returned.size()!=0){
                    for(String st : returned){
                        toReturn.add(" "+sb+st);
                    }
                }
            }
        }
        
        return dp[ind] = toReturn;
    }
}