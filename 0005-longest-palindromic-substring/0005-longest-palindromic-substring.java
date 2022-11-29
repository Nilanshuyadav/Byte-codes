class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String ans = "";
        int max = -1;
        
        for(int ind=0; ind<n; ind++){
                int temp = pallindrome(ind, ind, s, n);
            
            if(temp > max){
                max = temp;
                temp--;
                
                ans = sb.substring(ind-temp/2, (ind+temp/2)+1);
            }
            
            if(ind<n-1){
                temp = pallindrome(ind, ind+1, s, n);

                if(temp > max){
                    max = temp;
                    temp = temp/2;

                    ans = sb.substring(ind-temp+1, ind+1+temp);
                }
                    
            }
        }
        
        return ans;
    }
    
    public int pallindrome(int low, int high, String s, int n){
        while(0<=low && high<n && s.charAt(low)==s.charAt(high)){
            low--;
            high++;
        }
        
        return high-low-1;
    }
}