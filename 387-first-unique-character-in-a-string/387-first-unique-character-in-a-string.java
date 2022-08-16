class Solution {
    public int firstUniqChar(String s) {
        
//         Set<Character> set1 = new HashSet<>();
//         Set<Character> set2 = new HashSet<>();
        
//         int n = s.length();
        
//         for(int i=0;i<n;i++){
//             if(!set2.contains(s.charAt(i)) && !set1.add(s.charAt(i))){
//                 set1.remove(s.charAt(i));
//                 set2.add(s.charAt(i));
//             }
//         }
        
//         for(int i=0;i<n;i++){
//             if(set1.contains(s.charAt(i))){
//                 return s.indexOf(s.charAt(i));
//             }
//         }
        
//         return -1;
        
        int[] freq = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++) freq[s.charAt(i)-'a']++;
        
        for(int i=0;i<n;i++){
            if(freq[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }
}