class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length(),
            m = original.length;
        
        List<List<int[]>> adj = new ArrayList<>();
        List<int[]> al;
        long sum = 0, pre_sum;
        
        long[][] dp = new long[26][26];
        
        for(long i[] : dp){
            Arrays.fill(i, -1);
        }
        
        for(int i=0; i<26; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++){
            al = adj.get(original[i]-'a');
            
            al.add(new int[]{changed[i]-'a', cost[i]});
        }
        
        for(int i=0; i<n; i++){
            if(source.charAt(i) != target.charAt(i)){
                pre_sum = findMin(source.charAt(i)-'a', target.charAt(i)-'a', adj, dp);
                
                if(pre_sum == -1) return -1;
                
                sum += pre_sum;
            }
        }
        
        return sum;
    }
    
    public long findMin(int s, int e, List<List<int[]>> adj, long[][] dp){
        if(dp[s][e] != -1){
            return dp[s][e];
        }
        
        long[] vis = new long[26];
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]>0 ? 1 : -1);
        
        pq.add(new long[]{s, 0});
        
        long temp[];
        List<int[]> al;
        
        Arrays.fill(vis, (long)1e8);
        vis[s] = 0;
        
        while(!pq.isEmpty()){
            temp = pq.remove();
            
            // if(dp[(int)temp[0]][e] != -1){
            //     return dp[s][e] = temp[1]+dp[(int)temp[0]][e];
            // }
            
            if(temp[0] == e) return dp[s][e] = temp[1];
            
            al = adj.get((int)temp[0]);
            
            for(int[] i : al){
                if(vis[i[0]] > temp[1]+i[1]){
                    pq.add(new long[]{i[0], temp[1]+i[1]});
                    vis[i[0]] = temp[1]+i[1];
                }
            }
        }
        
        return -1;
    }
}