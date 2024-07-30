class Solution {
    public int minimumDeletions(String st) {
        int n = st.length();
        int[] pre = new int[n],
            suff = new int[n];
        
        pre[0] = st.charAt(0)=='b' ? 1 : 0;
        suff[n-1] = st.charAt(n-1)=='a' ? 1 : 0;
        
        for(int i=1, j=n-2; i<n; i++, j--){
            pre[i] = st.charAt(i)=='b' ? pre[i-1]+1 : pre[i-1];
            suff[j] = st.charAt(j)=='a' ? suff[j+1]+1 : suff[j+1];
        }
        
        int min = n;
        
        for(int i=0; i<n; i++){
            min = Math.min(min, pre[i]+suff[i]);
        }
        
        return min-1;
    }
}