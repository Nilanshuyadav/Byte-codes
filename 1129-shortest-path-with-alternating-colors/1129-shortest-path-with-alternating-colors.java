class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] r, int[][] b) {
        List<List<Integer>> redEdges = new ArrayList<>();
        List<List<Integer>> blueEdges = new ArrayList<>();
        boolean[][] vis = new boolean[2][n];
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        ans[0] = 0;
        
        for(int i=0;i<n;i++){
            redEdges.add(new ArrayList<>());
            blueEdges.add(new ArrayList<>());
        }
        
        for(int i[] : r)
            redEdges.get(i[0]).add(i[1]);
        for(int i[] : b)
            blueEdges.get(i[0]).add(i[1]);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int i=0;i<size;i++){
                Pair temp = q.remove();
                if(temp.color != 1){
                    for(int j : redEdges.get(temp.ind))
                        if(!vis[0][j]){
                            vis[0][j] = true;
                            q.add(new Pair(j,1));
                            if(ans[j] == -1) ans[j] = cnt;
                        }
                }
                
                if(temp.color != 2){
                    for(int j : blueEdges.get(temp.ind))
                        if(!vis[1][j]){
                            vis[1][j] = true;
                            q.add(new Pair(j,2));
                            if(ans[j] == -1) ans[j] = cnt;
                        }
                }
            }
        }
        return ans;
    }
}

class Pair{
    int ind;
    int color;
    public Pair(int ind,int color){
        this.ind = ind;
        this.color = color;
    }
}