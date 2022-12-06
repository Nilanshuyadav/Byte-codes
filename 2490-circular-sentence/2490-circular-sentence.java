class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        int n = s.length;
        
        for(int ind=1; ind<=n; ind++){
            if(ind == n)
                return s[ind-1].charAt(s[ind-1].length()-1) == s[0].charAt(0);
            
            else if(s[ind-1].charAt(s[ind-1].length()-1) != s[ind].charAt(0))
                return false;
        }
        
        return false;
    }
}