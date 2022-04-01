class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        int max = Integer.MIN_VALUE;
        String ans = new String("");
        
        if(n==1)
            return s;
        
        for(int i=0;i<n-1;i++){
            int len1 = helper(s,i,i,n);
            int len2 = helper(s,i,i+1,n);
            
            int m = Math.max(len1,len2);
            
            if(m > max) {
                ans = s.substring(i-((m-1)/2),i+(m/2)+1);
                max = m;
            }
        }
        
        return ans;
        
    }
    private Integer helper(String s,int start,int end,int n){
        while(start>=0 && end<n && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        
        return end-start-1;
    }
}