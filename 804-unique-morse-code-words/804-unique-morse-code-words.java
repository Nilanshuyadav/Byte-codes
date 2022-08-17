class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        
        for(String s : words){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<s.length();j++)
                sb.append(arr[s.charAt(j)-'a']);
            set.add(sb.toString());
        }
        
        
        
        return set.size();
    }
}