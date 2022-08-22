class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int j=0;j<n;j++)
            for(int i : graph[j])
                adj.get(j).add(i);
        
        List<Integer> al = new ArrayList<>();
        al.add(0);
        function(adj,0,n,al);
        
        return ans;
    }
    
    public void function(List<List<Integer>> adj, int ind,int n,List<Integer> al){
        for(int i : adj.get(ind)){
            if(i == n-1){
                al.add(i);
                ans.add(new ArrayList<>(al));
                al.remove(al.size()-1);
                continue;
            }
            else{
                al.add(i);
                function(adj,i,n,al);
                al.remove(al.size()-1);
            }
        }
    }
}