class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length, col = maze[0].length, level = -1;
        int[] r ={1,0,-1,0}, c = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int j=0;j<size;j++){
                int[] temp = q.remove();
                
                for(int i=0;i<4;i++){
                    int new_row = temp[0]+r[i];
                    int new_col = temp[1]+c[i];
                    
                    if((new_row<0 || new_col<0 || new_row>=row || new_col>=col) && level!=0) return level;
                    if((new_row>=0 && new_col>=0 && new_row<row && new_col<col) && maze[new_row][new_col] == '.'){
                        q.add(new int[]{new_row,new_col});
                        maze[new_row][new_col] = '+';
                    }
                }
            }
        }
        return -1;
    }
}