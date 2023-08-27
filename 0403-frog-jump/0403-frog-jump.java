class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ind=0; ind<n; ind++){
            map.put(stones[ind], ind);
        }
        
        Boolean[][] dp = new Boolean[n][n];
        
        return solve(0, stones, 0, n, dp, map);
    }
    
    
    public boolean solve(int ind, int[] stones, int k, int n, Boolean[][] dp, Map<Integer, Integer> map){
        if(ind == n-1){
            return true;
        }
        
        if(dp[ind][k] != null){
            return dp[ind][k];
        }
        
        boolean bool = false;
        int new_k;
        
        for(int i=-1; i<=1; i++){
            new_k = k+i;
            
            if(new_k>0 && map.containsKey(stones[ind]+new_k)){
                bool |= solve(map.get(stones[ind]+new_k), stones, new_k, n, dp, map);
            }
        }
        
//         if(k-1>0){            
//             if(map.containsKey(stones[ind]))
//                 bool |= solve(map.get(stones[ind]), stones, k-1, n, dp);
//         }
        
//         if(k>0){
//             if(temp!=-1)
//                 bool |= solve(temp, stones, k, n, dp);
//         }
        
//         if(k+1>0){
//             int temp = contains(stones, n, stones[ind]+k+1);
            
//             if(temp!=-1)
//                 bool |= solve(temp, stones, k+1, n, dp);
//         }
        
        return dp[ind][k] = bool;
    }
    
    public int contains(int[] stones, int n, int tar){
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(stones[m] == tar){
                return m;
            }
            else if(stones[m] < tar){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return -1;
    }
}