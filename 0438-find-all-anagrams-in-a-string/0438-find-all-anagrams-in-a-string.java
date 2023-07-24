class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int p_len = p.length(), s_len = s.length();
        
        if(s_len<p_len){
            return new ArrayList<>();
        }
        
        int[] fre_p = new int[26], fre_s = new int[26];
        
        for(int ind=0; ind<p_len; ind++){
            fre_p[p.charAt(ind)-'a']++;
        }
        
        int ind=0;
        List<Integer> al = new ArrayList<>();
        
        while(ind<s_len){
            if(ind<p_len-1){
                fre_s[s.charAt(ind)-'a']++;
            }
            else{
                fre_s[s.charAt(ind)-'a']++;
                
                if(equal(fre_s, fre_p)){
                    al.add(ind-p_len+1);
                }
                
                fre_s[s.charAt(ind-p_len+1)-'a']--;
            }
            
            ind++;
        }
        
        return al;
    }
    
    public boolean equal(int[] arr1, int[] arr2){
        for(int ind=0; ind<26; ind++){
            if(arr1[ind] != arr2[ind]){
                return false;
            }
        }
        
        return true;
    }
}