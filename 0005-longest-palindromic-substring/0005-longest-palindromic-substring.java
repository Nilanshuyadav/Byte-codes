class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), temp1, temp2;
        String ans = "";
        
        for(int i=0; i<n; i++){
            temp1 = findPalindrome(i, i, s);
            temp2 = findPalindrome(i, i+1, s);
            
            if(temp1>temp2 && temp1>ans.length()){
                ans = s.substring(i-(temp1/2), i+(temp1/2)+1);
            }
            else if(temp2>temp1 && temp2>ans.length()){
                ans = s.substring(i-(temp2/2)+1, i+(temp2/2)+1);
            }
        }
        
        return ans;
    }
    
    public int findPalindrome(int i, int j, String s){
        int n = s.length();
        
        while(0<=i && j<n && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        
        return j-i-1;
    }
}