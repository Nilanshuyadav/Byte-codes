class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n, ans=0;
        Set<Character> set = new HashSet<>();
        char ch;
        
        for(char c : allowed.toCharArray()){
            set.add(c);
        }
        
        for(String s : words){
            n = s.length();
            
            for(int i=0; i<n; i++){
                ch = s.charAt(i);
                
                if(!set.contains(ch)){
                    ans--;
                    i=n;
                }
            }
            
            ans++;
        }
        
        return ans;
    }
}