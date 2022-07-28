class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        
        if(n != m) return false;
        
        int[] chararr = new int[26];
        
        for(int i = 0;i<n;i++)
            chararr[s.charAt(i)-97]++;
        
        for(int i = 0; i<m;i++)
            chararr[t.charAt(i)-97]--;
        
        for(int i =0;i<26;i++)
            if(chararr[i] != 0) return false;
        
        return true;
    }
}