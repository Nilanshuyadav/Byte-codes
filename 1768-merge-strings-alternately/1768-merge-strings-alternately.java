class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1=word1.length(), n2=word2.length();
        
        StringBuilder sb = new StringBuilder("");
        
        boolean bool = true;
        
        int temp = n1+n2, i=0, j=0;
        
        while(i<n1 && j<n2){
            if(bool){
                sb.append(word1.charAt(i++));
            }
            else{
                sb.append(word2.charAt(j++));
            }
            
            bool = !bool;
        }
        
        if(i!=n1){
            sb.append(word1.substring(i));
        }
        
        if(j!=n2){
            sb.append(word2.substring(j));
        }
        
        return sb.toString();
    }
}