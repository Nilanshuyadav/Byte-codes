class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length(), m=t.length();
        
        if(n!=m) return false;
        
        Map<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<>();
        char c1, c2;
        
        for(int ind=0; ind<n ; ind++){
            c1 = s.charAt(ind);
            c2 = t.charAt(ind);
            
            if((map1.containsKey(c1) && map1.get(c1)!=c2) || (map2.containsKey(c2) && map2.get(c2)!=c1)) return false;
            
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        
        return true;
    }
}