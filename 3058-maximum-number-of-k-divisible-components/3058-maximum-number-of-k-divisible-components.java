class Solution {
    int cnt;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        cnt=0;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        boolean[] vis = new boolean[n];

        helper(0, adj, values, vis, k);
        return cnt;
    }

    public long helper(int ind, List<List<Integer>> adj, int[] val, boolean[] vis, int k){
        vis[ind] = true;
        long sum = val[ind];

        for(int i : adj.get(ind)){
            if(!vis[i]){
                sum += helper(i, adj, val, vis, k);        
            }
        }

        if(sum%k == 0){
            cnt++;
            return 0;
        }

        return sum;
    }
}