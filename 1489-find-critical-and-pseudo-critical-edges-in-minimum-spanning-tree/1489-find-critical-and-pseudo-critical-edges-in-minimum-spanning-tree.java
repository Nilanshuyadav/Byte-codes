class UnionFind{
    int[] rank, parent;
    public void union(int par_a, int par_b){
        
        if(rank[par_a] > rank[par_b]){
            parent[par_b] = par_a;
        }
        else if(rank[par_a] < rank[par_b]){
            parent[par_a] = par_b;
        }
        else{
            parent[par_b] = par_a;
            rank[par_a]++;
        }
    }
    
    public int findPar(int i){
        if(parent[i] == i)
            return i;
        
        return parent[i] = findPar(parent[i]);
    }
    
    public UnionFind(int n){
        rank = new int[n];
        parent = new int[n];
        
        for(int ind=0; ind<n; ind++){
            parent[ind] = ind;
        }
    }
}
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length, edge[];
        List<Integer> critical = new ArrayList<>(), pseudo_critical = new ArrayList<>();
        
        for(int ind=0; ind<m; ind++){
            edge = edges[ind];
            edge = Arrays.copyOf(edge, 4);
            edge[3] = ind;
            edges[ind] = edge;
        }
        
        Arrays.sort(edges, (a,b) -> a[2]-b[2]);
        
        int mstwt = findMST(n, edges, -1, -1);
        
        for(int ind=0; ind<m; ind++){
            if(mstwt < findMST(n, edges, ind, -1))
                critical.add(edges[ind][3]);
            else if(mstwt == findMST(n, edges, -1, ind))
                pseudo_critical.add(edges[ind][3]);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo_critical);
        
        return ans;
    }
    
    public int findMST(int n, int[][] edges, int block, int include){
        UnionFind uf = new UnionFind(n);
        
        int weight = 0;
        if(include != -1){
            weight += edges[include][2];
            uf.union(edges[include][0], edges[include][1]);
        }
        
        int par_a, par_b, ind[];
        
        for(int i=0; i<edges.length; i++){
            if(i==block) continue;
            
            ind = edges[i];
            
            par_a = uf.findPar(ind[0]);
            par_b = uf.findPar(ind[1]);
            
            if(par_a != par_b){
                weight += ind[2];
                
                uf.union(par_a, par_b);
            }
        }
        
        for(int i=0; i<n; i++){
            if(uf.findPar(i) != uf.findPar(0)){
                return Integer.MAX_VALUE;
            }
        }
        
        return weight;
    }
}