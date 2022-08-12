class Solution {
    public int minReorder(int n, int[][] connections) {
        // Set<Pair> set = new HashSet<>();
        Map<Integer,List<Integer>> ad = new HashMap<>();
        
        for(int i=0;i<n;i++)
            ad.put(i,new ArrayList<>());
        
        for(int i[] : connections)
            ad.get(i[0]).add(i[1]);
        
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
        //Pair temp_pair;
        int cnt = 0;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            vis[temp] = true;
            for(int i : adj.get(temp)){
                if(vis[i] != false) continue;
                //temp_pair = new Pair(temp,i);
                if(ad.get(temp).contains(i))
                    cnt++;
                q.add(i);
            }
        }
        return cnt;
    }
    
    public boolean contains2(List<int[]> set, int[] temp_pair){
        boolean temp = false;
        
        for(int i[] : set)
            temp  = temp || ((i[0]==temp_pair[0]) && i[1]==temp_pair[1]);
        
        return temp;
    }
    
}

class Pair{
    int from;
    int to;
    public Pair(int from, int to){
        this.from = from;
        this.to = to;
    }
}