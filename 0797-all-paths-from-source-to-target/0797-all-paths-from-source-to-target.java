class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = graph.length;
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int ind=0; ind<n; ind++){
            for(int inx : graph[ind])
                adj.get(ind).add(inx);
        }
        
        List<Integer> al = new ArrayList<>();
        al.add(0);
        q.add(new Pair(0, al));
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            int ind = temp.ind;
            List<Integer> path = temp.al;
            
            if(ind == n-1){
                ans.add(path);
                continue;
            }
            
            for(int inx : adj.get(ind)){
                path.add(inx);
                
                q.add(new Pair(inx, new ArrayList<>(path)));
                path.remove(path.size()-1);
            }
        }
        
        return ans;
    }
}

class Pair{
    int ind;
    List<Integer> al;
    public Pair(int ind, List<Integer> al){
        this.ind = ind;
        this.al = al;
    }
}