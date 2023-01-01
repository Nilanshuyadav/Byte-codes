class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, String> map = new HashMap<>();
        
        String[] arr = s.split(" ");
        int n = arr.length, p_len = pattern.length();
        
        if(n!=p_len)
            return false;
        
        for(int ind=0; ind<n; ind++){
            String ch = pattern.charAt(ind)+"";
            String word = arr[ind]+" ";
            
            if(map.containsKey(ch) && !map.get(ch).equals(word))
                return false;
            else if(map.containsKey(word) && !map.get(word).equals(ch))
                return false;
            else{
                map.put(ch, word);
                map.put(word, ch);
            }
        }
        
        return true;
    }
}