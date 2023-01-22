class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        solve(0, s, s.length(), "", new ArrayList<>(), ans);
        
        return ans;
    }
    
    public void solve(int ind, String s, int n, String temp_string, List<String> temp, List<List<String>> ans){
        if(ind == n){
            if(temp_string.equals(""))
                ans.add(new ArrayList<>(temp));
            
            return;    
        }
        
        StringBuilder sb = new StringBuilder(temp_string);
        
        sb.append(s.charAt(ind));
        
        if(isPalindrome(sb.toString())){
            temp.add(sb.toString());
            solve(ind+1, s, n, "", temp, ans);
            temp.remove(temp.size()-1);
        }
        
        solve(ind+1, s, n, sb.toString(), temp, ans);
    }
    
    public boolean isPalindrome(String sb){
        int low = 0, high = sb.length()-1;
        
        while(low<high){
            if(sb.charAt(low++) != sb.charAt(high--))
                return false;
        }
        
        return true;
    }
}