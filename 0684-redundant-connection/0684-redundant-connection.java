class Solution {
    int[] parent, rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int ind=0; ind<=n; ind++)
            parent[ind] = ind;
        
        
        for(int ind[] : edges){
            int a_par = findPar(ind[0]);
            int b_par = findPar(ind[1]);
            
            if(a_par == b_par)
                return ind;
            
            union(a_par, b_par);
        }
        
        return new int[]{0,0};
    }
    
    public void union(int a_par, int b_par){
        if(rank[a_par]<rank[b_par])
            parent[a_par] = b_par;
        else if(rank[b_par]<rank[a_par])
            parent[b_par] = a_par;
        else{
            parent[a_par] = b_par;
            rank[b_par]++;
        }
    }
    
    public int findPar(int node){
        if(parent[node] == node)
            return node;
        
        return parent[node] = findPar(parent[node]);
    }
}