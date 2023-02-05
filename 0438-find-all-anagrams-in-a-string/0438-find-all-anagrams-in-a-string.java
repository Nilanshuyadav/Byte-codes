class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int p_len = p.length();
        
        int[] p_freq = new int[26];
        for(int ind=0; ind<p_len; ind++){
            p_freq[p.charAt(ind)-'a']++;
        }
        
        int n = s.length();
        
        int[] freq = new int[26];
        
        for(int ind=0; ind<n; ind++){
            freq[s.charAt(ind)-'a']++;
            
            if(ind>=p_len-1){
                if(compare(freq, p_freq))
                    ans.add(ind-p_len+1);
                
                freq[s.charAt(ind-p_len+1)-'a']--;
            }
        }
        
        return ans;
    }
    
    public boolean compare(int[] freq, int[] p_freq){
        for(int ind=0; ind<26; ind++)
            if(freq[ind] != p_freq[ind])
                return false;
        
        return true;
    }
}