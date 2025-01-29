class Solution {
    int[] parent, rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<n; i++){
            if(!canWe(edges[i])){
                return edges[i];
            }
        }

        return null;
    }

    public int findPar(int u){
        if(parent[u] == u) return u;
        return parent[u] = findPar(parent[u]);
    }

    public boolean canWe(int[] arr){
        int u = arr[0], v = arr[1];

        int par_u = findPar(u), par_v = findPar(v);

        if(par_u == par_v) return false;

        if(rank[par_u]<rank[par_v]){
            parent[par_u] = par_v;
        }
        else if(rank[par_v]<rank[par_u]){
            parent[par_v] = par_u;
        }
        else{
            parent[par_u] = par_v;
            rank[par_v]++;
        }

        return true;
    }
}