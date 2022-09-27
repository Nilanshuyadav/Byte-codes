class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        int n = s.length();
        
        s = s.toLowerCase();
        
        for(int ind=n-1; ind>=0; ind--)
            if(Character.isLetter(s.charAt(ind)) || (s.charAt(ind)>='0' && s.charAt(ind)<='9')) sb.append(s.charAt(ind));

        return sb.toString().equals(sb.reverse().toString());
    }
}