class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m=t.length();
        
        if(n!=m) return false;
        
        int[] fre = new int[26];
        
        for(int i=0; i<n; i++)
        {
            fre[s.charAt(i)-'a']++;        
        }   
        
        for(int i=0; i<n; i++){
            fre[t.charAt(i)-'a']--;
        }
        
        for(int i : fre){
            if(i!=0) return false;
        }
        
        return true;
    }
}