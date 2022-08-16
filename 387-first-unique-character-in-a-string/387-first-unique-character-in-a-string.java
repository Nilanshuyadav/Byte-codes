class Solution {
    public int firstUniqChar(String s) {
        Set<Character> set1 = new HashSet<>(), set2 = new HashSet<>();
        
        int n = s.length();
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(!set2.contains(ch) && set1.add(ch)){}
            else{
                set1.remove(ch);
                set2.add(ch);
            }
        }
        
        if(set1.size() == 0) return -1;
        
        for(int i=0;i<n;i++){
            if(set1.contains(s.charAt(i)))
                return i;
        }
        
        return -1;
    }
}