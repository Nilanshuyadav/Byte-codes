class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length(), temp_count=0;
        
        if(n==1)
            return "";
        
        StringBuilder sb = new StringBuilder(palindrome);
        
        for(int ind=0; ind<n; ind++){
            if(sb.charAt(ind) != 'a' && (n%2==0 || ind!=(n/2))){
                sb.setCharAt(ind, 'a');
                break;
            }
            else 
                temp_count++;
        }
        
        if(temp_count == n){
            sb.setCharAt(n-1, 'b');
        }
        
        return sb.toString();
    }
}