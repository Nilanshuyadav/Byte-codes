class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        //boolean[][] vis = new boolean[row][col];
        int ans = 0;
        int[] r = {-1,0,1,0}, c = {0,1,0,-1};
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    q.add(new Pair(i,j));
                    ans++;
                    
                    while(!q.isEmpty()){
                        Pair temp = q.remove();
                        for(int k=0;k<4;k++){
                            int new_row = temp.row+r[k];
                            int new_col = temp.col+c[k];
                            
                            if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || grid[new_row][new_col]=='0') continue;
                            
                            grid[new_row][new_col] = '0';
                            q.add(new Pair(new_row,new_col));
                        }
                    }
                }
            }
        return ans;
    }
}

class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}