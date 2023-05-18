class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Stack<Integer> st = new Stack<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> al : edges){
            adj.get(al.get(0)).add(al.get(1));
        }
        
        boolean[] vis = new boolean[n];
        
        for(int ind=0; ind<n; ind++){
            if(!vis[ind]){
                findTopo(ind, st, adj, vis);
            }
        }
        
        int cnt=0;
        for(int ind=0; ind<n; ind++){
            vis[ind] = false;
        }
        
        List<Integer> ans = new ArrayList<>();
        int temp;
        
        while(!st.isEmpty()){
            temp = st.pop();
            
            if(vis[temp]){
                continue;
            }
            
            cnt += findRange(temp, adj, vis);
            ans.add(temp);
            
            if(cnt == n){
                break;
            }
        }
        
        return ans;
    }
    
    public int findRange(int ind, List<List<Integer>> adj, boolean[] vis){
        int sum = 0;
        
        for(int inx : adj.get(ind)){
            if(!vis[inx]){
                sum += findRange(inx, adj, vis);
            }    
        }
        
        vis[ind] = true;
        return sum+1;
    }
    
    public void findTopo(int ind, Stack<Integer> st, List<List<Integer>> adj, boolean[] vis){
        for(int inx : adj.get(ind)){
            if(!vis[inx]){
                findTopo(inx, st, adj, vis);
            }
        }
        
        vis[ind] = true;
        st.add(ind);
    }
}