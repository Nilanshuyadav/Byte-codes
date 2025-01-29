class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent, rank;

        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<n; i++){
            if(!canWe(edges[i], parent, rank)){
                return edges[i];
            }
        }

        return null;
    }

    public int findPar(int u, int[] parent){
        if(parent[u] == u) return u;
        return parent[u] = findPar(parent[u], parent);
    }

    public boolean canWe(int[] arr, int[] parent, int[] rank){
        int u = arr[0], v = arr[1];

        int par_u = findPar(u, parent), par_v = findPar(v, parent);

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