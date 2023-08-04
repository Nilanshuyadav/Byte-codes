class Solution {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        
        solve(0, s.length(), s, "", new HashSet<>(wordDict));
        
        return ans;
    }
    
    public void solve(int ind, int n, String s, String temp, Set<String> set){
        if(ind == n){
            ans.add(temp.substring(1));
            return;
        }
        
        StringBuilder sb = new StringBuilder("");
        char ch;
        
        for(int i=ind; i<n; i++){
            ch = s.charAt(i);
            
            sb.append(ch);
            
            if(set.contains(sb.toString())){
                solve(i+1, n, s, temp+" "+sb, set);
            }
        }
    }
}