class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<words.length;i++){
            StringBuilder sb = new StringBuilder(), temp = new StringBuilder(words[i]);
            for(int j=0;j<temp.length();j++)
                sb.append(arr[temp.charAt(j)-'a']);
            set.add(sb.toString());
        }
        
        
        
        return set.size();
    }
}