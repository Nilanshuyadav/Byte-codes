class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] arr = new int[26];
        
        for(char ch : letters){
            arr[ch-'a']++;
        }
        
        return helper(words.length-1, words, arr, score);
    }
    
    public int helper(int ind, String[] words, int[] arr, int[] score){
        if(ind == -1){
            return 0;
        }
        
        char ch;
        int sum = 0;
        int max = 0;
        
        if(canTake(words[ind], arr)){
            for(int i=0; i<words[ind].length(); i++){
                ch = words[ind].charAt(i);
                
                arr[ch-'a']--;
                sum += score[ch-'a'];
            }
            
            max = sum + helper(ind-1, words, arr, score);
            
            for(int i=0; i<words[ind].length(); i++){
                ch = words[ind].charAt(i);
                
                arr[ch-'a']++;
            }
        }
        
        max = Math.max(max, helper(ind-1, words, arr, score));
        
        return max;
    }
    
    public boolean canTake(String st, int[] arr){
        char ch;
        
        int[] temp = new int[26];
        
        for(int i=0; i<st.length(); i++){
            ch = st.charAt(i);
            
            temp[ch-'a']++;
        }
        
        for(int i=0; i<26; i++){
            if(arr[i]<temp[i]) return false;
        }
        
        
        return true;
    }
}