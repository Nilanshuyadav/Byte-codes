class Solution {
    int pattern_length;
    Map<Character,Integer> pmap = new HashMap<>();
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        pattern_length = pattern.length();
        
        for(char ch : pattern.toCharArray())
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);
        
        List<String> ans = new ArrayList<>();
        
        for(String st : words)
            if(function(st,pattern))
                ans.add(st);
        
        return ans;
    }
    
    public boolean function(String st,String pattern){
        if(st.length() != pattern_length) return false;
        
        Map<Character,Integer> stmap = new HashMap<>();
        
        char[] starr = st.toCharArray();
        
        for(char ch : starr)
            stmap.put(ch,stmap.getOrDefault(ch,0)+1);
        
        Map<Character,Character> mapping = new HashMap<>();
        
        char ch;
        
        for(int i =0;i<pattern_length;i++){
            ch = pattern.charAt(i);
            
            if(mapping.containsKey(ch)){
                if(st.charAt(i) != mapping.get(ch)) return false;
            }
            else{
                if(pmap.get(ch) != stmap.get(st.charAt(i))) return false;
                else mapping.put(ch,st.charAt(i));
            }
        }
        
        return true;
    }
}