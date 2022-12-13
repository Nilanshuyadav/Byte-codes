class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];
        
        int ind=0, temp = Integer.MIN_VALUE;
        
        while(ind<n){
            if(ind+2<n && !vis[ind+2]){
                vis[ind+2] = true;
                temp = Math.max(temp, stones[ind+2] - stones[ind]);
                ind += 2;
            }

            else if(ind+1<n && !vis[ind+1]){
                vis[ind+1] = true;
                temp = Math.max(temp, stones[ind+1]-stones[ind]);
                ind += 1;
            }
            
            if(ind == n-1)
                break;
        }
        
        ind = n-1;
        
        while(0<=ind){
            if(0<=ind-2 && !vis[ind-2]){
                vis[ind-2] = true;
                temp = Math.max(temp, stones[ind]-stones[ind-2]);
                ind -= 2;
            }

            else if(0<=ind-1 && !vis[ind-1]){
                vis[ind-1] = true;
                temp = Math.max(temp, stones[ind]-stones[ind-1]);
                ind -= 1;
            }
            
            if(ind == 0)
                break;
        }
        
        return temp;
    }
    
    public int fordward(int ind, int[] stones, int n, boolean[] vis){
        int temp = Integer.MIN_VALUE;
        
        if(ind+2<n && !vis[ind+2]){
            vis[ind+2] = true;
            temp = Math.max(Math.abs(stones[ind+2] - stones[ind]), fordward(ind+2, stones, n, vis));
        }
        
        else if(ind+1<n && !vis[ind+1]){
            vis[ind+1] = true;
            temp = Math.max(Math.abs(stones[ind+1]-stones[ind]), fordward(ind+1, stones, n, vis));
        }
        
        if(0<=ind-2 && !vis[ind-2]){
            vis[ind-2] = true;
            temp = Math.max(Math.abs(stones[ind]-stones[ind-2]), fordward(ind-2, stones, n, vis));
        }
        
        else if(0<=ind-1 && !vis[ind-1]){
            vis[ind-1] = true;
            temp = Math.max(Math.abs(stones[ind]-stones[ind-1]), fordward(ind-1, stones, n, vis));
        }
        
        return temp;            
    }
}