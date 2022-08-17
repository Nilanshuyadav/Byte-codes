class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        
        for(String s : words){
            String sb = new String();
            for(int j=0;j<s.length();j++)
                sb += (arr[s.charAt(j)-'a']);
            set.add(sb);
        }
        
        
        
        return set.size();
    }
}