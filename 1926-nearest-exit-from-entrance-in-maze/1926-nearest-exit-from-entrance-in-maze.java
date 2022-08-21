class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int cnt = 1,row = maze.length,col = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] r = {-1,0,1,0}, c = {0,1,0,-1};
        boolean[][] vis = new boolean[row][col];
        vis[entrance[0]][entrance[1]] = true;
        
        q.add(entrance);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j=0;j<size;j++){
                int[] temp = q.remove();

                for(int i=0;i<4;i++){
                    int new_row = temp[0]+r[i];
                    int new_col = temp[1]+c[i];
                    
                    if(new_row<0 || new_col<0 || new_row>=row || new_col>=col){
                        if(temp[0] == entrance[0] && temp[1]==entrance[1]) continue;
                        else return cnt-1;
                    }

                    if(maze[new_row][new_col] == '+') continue;
                    
                    if(new_row>=0 && new_col>=0 && new_row<row && new_col<col && !vis[new_row][new_col]){
                        vis[new_row][new_col] = true;
                        q.add(new int[]{new_row,new_col});
                    }
                    


                }
            }
            cnt++;
        }
        
        return -1;
    }
}