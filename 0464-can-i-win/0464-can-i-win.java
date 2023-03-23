class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal > (maxChoosableInteger*(maxChoosableInteger+1))/2)  return false;
        if(desiredTotal <= 0)   return true;
        
        Map<Integer, Boolean> map = new HashMap<>();
        boolean[] vis = new boolean[maxChoosableInteger + 1];
        
        return solve(desiredTotal, map, maxChoosableInteger+1, vis);
    }
    
    public boolean solve(int desiredTotal, Map<Integer, Boolean> map, int n, boolean[] vis){
        if(desiredTotal <= 0)
            return false;
        
        int key = bitMask(vis);
        
        if(map.containsKey(key))
            return map.get(key);
        
        for(int ind=1; ind<n; ind++){
            if(!vis[ind]){
                vis[ind] = true;
                
                if(!solve(desiredTotal-ind, map, n, vis)){
                    map.put(key, true);
                    vis[ind] = false;
                    return true;
                }
                
                vis[ind] = false;
            }
        }
        
        map.put(key, false);
        return false;
    }
    
    public int bitMask(boolean[] vis){
        int num=0;
        
        for(boolean b : vis){
            num <<= 1;
            
            if(b)
                num |= 1;
        }
        
        return num;
    }
}