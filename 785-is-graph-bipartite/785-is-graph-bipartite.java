class Solution {
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        color = new int[n];
        Arrays.fill(color,-1);
        
        for(int i =0;i<n;i++)
            if(color[i] == -1){
                color[i] = 0;
                if(!function(i,-1,graph))
                    return false;
            }    
        
        return true;
    }
    
    public boolean function(int ind, int parent, int[][] graph){
        int ind_color = color[ind];
        System.out.println(ind);
        
        for(int i: graph[ind]){
            if(i == parent) continue;
            
            if(color[i] != -1){
                if(color[i] == ind_color) return false;
                else continue;
            }
            
            color[i] = ind_color==0?1:0;
            if(!function(i,ind,graph)) return false;
        }
        
        return true;
    }
}