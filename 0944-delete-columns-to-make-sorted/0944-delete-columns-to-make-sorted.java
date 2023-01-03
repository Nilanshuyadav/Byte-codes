class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        
        int cnt=0;
        char[] ch = new char[m];
        Arrays.fill(ch, 'a');
        
        for(int ind=0; ind<n; ind++){
            String st = strs[ind];
            
            for(int inx=0; inx<m; inx++){
                if(ch[inx] == '*')
                    continue;
                
                if(ch[inx]>st.charAt(inx)){
                    cnt++;
                    ch[inx] = '*';
                }
                else
                    ch[inx] = st.charAt(inx);
            }
        }
        
        return cnt;
    }
}