class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length(), s_len = s.length();
        int inx_s = 0;
        
        for(int ind=0; ind<n; ind++){
            if(inx_s<s_len && t.charAt(ind)==s.charAt(inx_s)) inx_s++;
        }
        
        return inx_s==s_len;
    }
}