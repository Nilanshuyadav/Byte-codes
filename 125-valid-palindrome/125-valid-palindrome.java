class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder st = new StringBuilder("");
        
        for(int i=0;i<n;i++){
            if(Character.isLetter(s.charAt(i)) || (s.charAt(i)>='0' && s.charAt(i)<='9'))
                st.append(Character.toLowerCase(s.charAt(i)));
            
        }
        
        return checkPallindrome(0,st.length()-1,st.toString());
        
    }
    
    private boolean checkPallindrome(int low,int high,String s){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high))
                return false;
            
            low++;
            high--;
        }
        
        return true;
    }
}