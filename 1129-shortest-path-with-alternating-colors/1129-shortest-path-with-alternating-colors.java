class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();
        
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i[] : redEdges)
            adj.get(i[0]).add(new int[]{1,i[1]});
        
        for(int i[] : blueEdges)
            adj.get(i[0]).add(new int[]{2,i[1]});
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,-1,0));
        
        Set<String> set = new HashSet<>();
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                Pair temp = q.remove();
                
                int currval = temp.val;
                int currlength = temp.length;
                int currcolor = temp.color;
                
                if(ans[currval] == -1) ans[currval] = currlength+1;
                
                String st = new StringBuilder()
                    .append(currval)
                    .append(",")
                    .append(currcolor).toString();
                
                if(!set.contains(st)){
                    for(int[] i : adj.get(currval)){
                        int val = i[1];
                        int col = i[0];
                        
                        if(col != currcolor) q.add(new Pair(val,currlength+1,col));
                    }
                }
                set.add(st);
            }
        }
        return ans;
    }
}

class Pair{
    int val;
    int length;
    int color;
    
    public Pair(int val, int length, int color){
        this.val = val;
        this.length = length;
        this.color = color;
    }
}