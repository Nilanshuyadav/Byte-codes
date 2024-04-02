class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length(), m=t.length();
        
        if(n!=m) return false;
        
        Map<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<Character, Character>();        
        int i=0, j=0;
        char ch1, ch2;
        
        while(i<n && j<m){
            ch1 = s.charAt(i);
            ch2 = t.charAt(j);
            
            if(map1.containsKey(ch1) && map1.get(ch1)!=ch2) return false;
            else if(map2.containsKey(ch2) && map2.get(ch2)!=ch1) return false;
            
            map1.put(ch1, ch2);
            map2.put(ch2, ch1);
            
            i++;
            j++;
        }
        
        return true;
    }
}