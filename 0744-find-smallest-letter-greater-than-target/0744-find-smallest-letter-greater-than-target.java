class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        target = (char)(target+1);
        
        int l=0, n=letters.length, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(letters[m] == target){
                return letters[m];
            }
            else if(letters[m] < target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return h==n-1 ? letters[0] : letters[h+1];
    }
}