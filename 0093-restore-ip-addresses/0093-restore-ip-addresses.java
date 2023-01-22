class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        
        solve(0, s.length(), 4, s, "", ans);
        
        return ans;
    }
    
    public void solve(int ind, int n, int k, String s, String temp, List<String> ans){
        if(k==0){
            if(ind==n)
                ans.add(temp.substring(0, temp.length()-1));
            return;
        }
        
        StringBuilder sb = new StringBuilder(temp);
        
        for(int i=ind; i<n; i++){
            sb.append(s.charAt(i));
            
            if(isValid(s, ind, i)){
                sb.append('.');
                solve(i+1, n, k-1, s, sb.toString(), ans);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    
    public boolean isValid(String s, int start, int end){
        if(start!=end && s.charAt(start)=='0')
            return false;
        
        long number = Long.valueOf(s.substring(start, end+1));
        
        if(number<0 || number>255)
            return false;
        
        return true;
    }
}