class DSU{
    int rank[], parent[];
    
    public void union(int par_a, int par_b){
        if(rank[par_a] < rank[par_b]){
            parent[par_a] = par_b;
        }
        else if(rank[par_a] > rank[par_b]){
            parent[par_b] = par_a;
        }
        else{
            parent[par_a] = par_b;
            rank[par_b]++;
        }
    }
    
    public int findPar(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = findPar(parent[a]);
    }
    
    public DSU(int n){
        rank = new int[n];
        parent = new int[n];
        
        for(int ind=0; ind<n; ind++)
            parent[ind] = ind;
    }
}
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length, temp[];
        
        for(int ind=0; ind<m; ind++){
            temp = edges[ind];
            
            temp = Arrays.copyOf(temp, 4);
            temp[3] = ind;
            
            edges[ind] = temp;
        }
        
        Arrays.sort(edges, (a,b) -> a[2]-b[2]);
        List<Integer> critical = new ArrayList<>(), pseudo_critical = new ArrayList<>();
        
        int mstwt = findMST(edges, n, m, -1, -1);
        
        for(int ind=0; ind<m; ind++){
            if(findMST(edges, n, m, -1, ind) > mstwt){
                critical.add(edges[ind][3]);
            }
            else if(findMST(edges, n, m, ind, -1) == mstwt){
                pseudo_critical.add(edges[ind][3]);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        ans.add(critical);
        ans.add(pseudo_critical);
        
        return ans;
    }
    
    public int findMST(int[][] edges, int n, int m, int i, int e){
        DSU uf = new DSU(n);
        
        int weight = 0, par_a, par_b;
        
        if(i != -1){
            uf.union(edges[i][0], edges[i][1]);
            weight += edges[i][2];
        }
        
        for(int ind=0; ind<m; ind++){
            if(ind == e)
                continue;
            
            par_a = uf.findPar(edges[ind][0]);
            par_b = uf.findPar(edges[ind][1]);
            
            if(par_a != par_b){
                uf.union(par_a, par_b);
                weight += edges[ind][2];
            }
        }
        
        for(int ind=0; ind<n; ind++){
            if(uf.findPar(ind) != uf.findPar(0)){
                return Integer.MAX_VALUE;
            }
        }
        
        return weight;
    }
}