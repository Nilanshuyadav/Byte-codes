class Solution {
    int sum;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] node_arr = new int[n];
        sum = 0;
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : edges){
            adj.get(ind[0]).add(ind[1]);
            adj.get(ind[1]).add(ind[0]);
        }
        
        count_node(0, node_arr, adj, -1);
        
        count_sum(0, 0, adj, -1);
        
        int[] res_arr = new int[n];
        res_arr[0] = sum;
        
        for(int ind : adj.get(0))
            solve(ind, node_arr, adj, res_arr, 0, n);
        
        return res_arr;
    }
    
    public void solve(int node, int[] node_arr, List<List<Integer>> adj, int[] res_arr, int parent, int n){
        res_arr[node] = res_arr[parent] - (node_arr[node]-1) + (n-node_arr[node]-1);
        
        for(int ind : adj.get(node)){
            if(ind == parent)
                continue;
            
            solve(ind, node_arr, adj, res_arr, node, n);
        }
    }
    
    public void count_sum(int node, int height, List<List<Integer>> adj, int parent){
        sum += height;
        
        for(int ind : adj.get(node)){
            if(ind == parent)
                continue;
            
            count_sum(ind, height+1, adj, node);
        }
    }
    
    public int count_node(int node, int[] node_arr, List<List<Integer>> adj, int parent){
        int ans = 1;
        
        for(int ind : adj.get(node)){
            if(ind == parent)
                continue;
            
            ans += count_node(ind, node_arr, adj, node);
        }
        
        return node_arr[node] = ans;
    }
}