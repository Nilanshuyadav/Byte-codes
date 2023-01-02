class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        
        if(n==1)
            return true;
        
        if('A'<=word.charAt(0) && word.charAt(0)<='Z'){
            if(Character.isUpperCase(word.charAt(1))){
                for(int ind=2; ind<n; ind++)
                    if(Character.isLowerCase(word.charAt(ind)))
                        return false;
            }
            else{
                for(int ind=2; ind<n; ind++)
                    if(Character.isUpperCase(word.charAt(ind)))
                        return false;
            }
        }
        else{
            for(int ind=1; ind<n; ind++){
                if(Character.isUpperCase(word.charAt(ind)))
                    return false;
            }
        }
        
        return true;
    }
}