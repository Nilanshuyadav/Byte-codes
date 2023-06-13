class Solution {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        
        for(int ind=0; ind<n; ind++){
            set.add(s.charAt(ind));
        }
        
        return set.size();
    }
}