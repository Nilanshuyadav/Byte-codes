class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        
        int low = 0, high = sb.length()-1;
        
        while(low<high){
            if(sb.charAt(low++) != sb.charAt(high--))
                return false;
        }
        
        return true;
    }
}