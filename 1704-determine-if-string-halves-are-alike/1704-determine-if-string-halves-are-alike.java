class Solution {
    public boolean halvesAreAlike(String s) {
        int first_half_vowel = 0, second_half_vowel = 0, n = s.length();
        
        for(int i=0, j=n/2; j<n; i++, j++){
            char first_ch = s.charAt(i), second_ch = s.charAt(j);
            
            if(first_ch=='a' || first_ch=='e' || first_ch=='i' || first_ch=='o' || first_ch=='u' || first_ch=='A' || first_ch=='E' || first_ch=='I' || first_ch=='O' || first_ch=='U')
                first_half_vowel++;
            
            if(second_ch=='a' || second_ch=='e' || second_ch=='i' || second_ch=='o' || second_ch=='u' || second_ch=='A' || second_ch=='E' || second_ch=='I' || second_ch=='O' || second_ch=='U')
                second_half_vowel++;
        }
        
        return first_half_vowel == second_half_vowel;
    }
}