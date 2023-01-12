class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(int ind[] : edges){
            adj.get(ind[0]).add(ind[1]);
            adj.get(ind[1]).add(ind[0]);
        }
        
        solve(0, adj, labels, ans, -1);
        
        return ans;
    }
    
    public int[] solve(int ind, List<List<Integer>> adj, String labels, int[] ans, int parent){
        
        int[][] arr = new int[adj.get(ind).size()][26];
        int[] to_return = new int[26];
        int k=0;
        
        for(int inx : adj.get(ind)){
            if(inx == parent)
                continue;
            arr[k++] = solve(inx, adj, labels, ans, ind);    
        }
        
        for(int i=0; i<26; i++){
            for(int j=0; j<adj.get(ind).size(); j++)
                to_return[i] += arr[j][i];
        }
        
        to_return[labels.charAt(ind)-'a']++;
        
        ans[ind] = to_return[labels.charAt(ind)-'a'];
        
        return to_return;
    }
}