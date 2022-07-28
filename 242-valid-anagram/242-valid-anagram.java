class Solution {
    public boolean isAnagram(String s, String t) {
        StringBuilder ss = new StringBuilder(s), ts = new StringBuilder(t);
        int n = ss.length(), m = ts.length();
        
        if(n != m) return false;
        
        int[] chararr = new int[26];
        
        for(int i = 0;i<n;i++)
            chararr[ss.charAt(i)-97]++;
        
        for(int i = 0; i<m;i++)
            chararr[ts.charAt(i)-97]--;
        
        for(int i =0;i<26;i++)
            if(chararr[i] != 0) return false;
        
        return true;
    }
}