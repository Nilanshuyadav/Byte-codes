class Solution {
    public int maxDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        
        int[] r = {-1,0,1,0}, c = {0,1,0,-1};
        
        int[][] ans = new int[n][n];
        for(int i[] : ans)
            Arrays.fill(i,Integer.MAX_VALUE);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) {ans[i][j] = 0; q.add(new Pair(i,j));}
            }
        }
        
        if(q.isEmpty() || q.size() == n*n) return -1;
        
        while(!q.isEmpty()){
            
            Pair temp = q.remove();

            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];

                if(new_row<0 || new_col<0 || new_row>=n || new_col>=n || ans[new_row][new_col] != Integer.MAX_VALUE) continue;

                ans[new_row][new_col] = 1+ans[temp.row][temp.col];
                q.add(new Pair(new_row,new_col));
            }
            
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                max = Math.max(max,ans[i][j]);
        }
        return max;
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