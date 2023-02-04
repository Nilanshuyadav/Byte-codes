class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        
        if(len1>len2)
            return false;
        
        int[] fre = new int[26];
        
        for(int ind=0; ind<len1; ind++){
            fre[s1.charAt(ind)-'a']++;
        }
        
        int fre2[] = new int[26];
        
        for(int ind=0; ind<len2; ind++){
            if(ind<len1-1){
                fre2[s2.charAt(ind)-'a']++;
            }
            else if(ind==len1-1){
                fre2[s2.charAt(ind)-'a']++;
                
                if(compare(fre, fre2))
                    return true;
            }
            else{
                fre2[s2.charAt(ind)-'a']++;
                fre2[s2.charAt(ind-len1)-'a']--;
                
                if(compare(fre, fre2))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean compare(int[] fre1, int[] fre2){
        for(int ind=0; ind<26; ind++)
            if(fre1[ind] != fre2[ind])
                return false;
        return true;
    }
}