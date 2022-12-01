class Solution {
    public boolean halvesAreAlike(String s) {
        int total_vowel = 0, n = s.length();
        
        for(int ind=n/2; ind<n; ind++){
            char ch = s.charAt(ind);
            
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
                total_vowel++;
        }
        
        int curr_vowel = 0;
        
        for(int ind=0; ind<n/2; ind++){
            char ch = s.charAt(ind);
            
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
                curr_vowel++;
        }
        
        return curr_vowel == total_vowel;
    }
}