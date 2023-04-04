class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int ans=0;
        
        int[] fre = new int[26];
        
        char ch;
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(fre[ch-'a'] != 0){
                ans++;
                
                Arrays.fill(fre, 0);
            }
            
            fre[ch-'a']++;
        }
        
        return ans+1;
    }
}