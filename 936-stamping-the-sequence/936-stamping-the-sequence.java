class Solution {
    public int[] movesToStamp(String stamp, String target) {
        List<Integer> ans = new ArrayList<>();
        char[] tarr = target.toCharArray();
        char[] sarr = stamp.toCharArray();
        
        int cnt = 0,n = tarr.length;
        boolean[] vis = new boolean[n];
        
        while(cnt != n){
            boolean hasChanged = false;
            
            for(int i=0;i<=n-sarr.length;i++){
                if(!vis[i] && canChange(sarr,i,sarr.length,tarr)){
                    hasChanged = true;
                    vis[i] = true;
                    cnt = change(tarr,i,sarr.length,cnt);
                    ans.add(i);
                    if(cnt == n) break;
                }
            }
            if(!hasChanged) return new int[0];
        }
        
        int[] rans = new int[ans.size()];
        int k = 0;
        for(int i=ans.size()-1;i>=0;i--) rans[k++] = ans.get(i);
        
        return rans;
        
    }
    
    public boolean canChange(char[] sarr, int pos, int len, char[] tarr){
        for(int i=0;i<len;i++){
            if(tarr[i+pos] != '?' && tarr[i+pos]!=sarr[i])return false;
        }
        return true;
    }
    
    public int change(char[] tarr,int pos,int len,int cnt){
        for(int i=0;i<len;i++){
            if(tarr[i+pos] != '?'){
                cnt++;
                tarr[i+pos] = '?';
            }
        }
        return cnt;
    }
}