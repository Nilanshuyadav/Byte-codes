class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<String> set = new HashSet<>();
        
        for(int i[] : connections)
            set.add(new StringBuilder().append(i[0]).append(",").append(i[1]).toString());
        
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i[] : connections){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int cnt = 0;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            vis[temp] = true;
            for(int i : adj.get(temp)){
                if(vis[i] != false) continue;
                // final int temp_from = temp;
                // final int temp_to = i;
                String temp_s = new StringBuilder().append(temp).append(",").append(i).toString();
                if(set.contains(temp_s))
                    cnt++;
                q.add(i);
            }
        }
        
        
        return cnt;
    }
    
//     public boolean contains2(List<int[]> set, int[] temp_pair){
//         boolean temp = false;
        
//         for(int i[] : set)
//             temp  = temp || ((i[0]==temp_pair[0]) && i[1]==temp_pair[1]);
        
//         return temp;
//     }
    
}

class Pair{
    int from;
    int to;
    public Pair(int from, int to){
        this.from = from;
        this.to = to;
    }
}