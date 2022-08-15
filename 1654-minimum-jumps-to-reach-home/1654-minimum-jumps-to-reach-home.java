class Solution {
    
    public void solve(Queue<Pair<Integer,Integer>> bfs,Set<Pair<Integer,Integer>> vis,Set<Integer> fore,int x,int flag,int[] range){
        Pair<Integer,Integer> temp=new Pair<>(x,flag);
        if(vis.contains(temp) || fore.contains(x) || range[0] > x || range[1] < x)return;
        bfs.add(temp);
        vis.add(temp);
        // Pair temp=new Pair(3,1);
        //                             System.out.println(vis.contains(temp));
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int m=forbidden[0];
        for(int i:forbidden)m=Math.max(m,i);
        int range[]={0,Math.max(m,x)+a+b}; // Main Logic is to find out the range where we can restrict the bfs algorithm
        Set<Integer> fore=new HashSet<>(); // set for forbidden Area
        Set<Pair<Integer,Integer>> vis=new HashSet<>(); // set for visited area
        for(int i:forbidden)fore.add(i); 
        Queue<Pair<Integer,Integer>> bfs=new ArrayDeque<>(); // BFS drill
        int start=0; // starting Position
        
        bfs.add(new Pair<>(0,1));
        int level=0; 
        while(bfs.size() > 0){
            int s=bfs.size();
            for(int i=0;i<s;i++){
                Pair<Integer,Integer> t=bfs.poll();
                if(t.getKey() == x)return level;
                if(t.getValue() == 1){
                    solve(bfs,vis,fore,t.getKey()+a,1,range);
                    solve(bfs,vis,fore,t.getKey()-b,-1,range);
                }else{
                    solve(bfs,vis,fore,t.getKey()+a,1,range);
                }
            }
            level++;
        }
        return -1;
    }
}

