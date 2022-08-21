class Solution {
    int[] r = {-1,0,1,0}, c = {0,1,0,-1};
    int n;
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        char[] carr = word.toCharArray();
        n = carr.length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == carr[0]){
                    if(function(1,board,carr,i,j,new boolean[row][col]))
                        return true;
                }
            }
        }
        
    
        return false;
    }
    
    public boolean function(int ind,char[][] board, char[] carr,int row, int col, boolean[][] vis){
        if(ind == n) return true;
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int nr = row+r[i];
            int nc = col+c[i];
            
            if(nr<0 || nc<0 || nr>=board.length || nc>=board[0].length || vis[nr][nc]) continue;
            if(board[nr][nc] == carr[ind]){
                vis[nr][nc] = true;
                if(function(ind+1,board,carr,nr,nc,vis))
                    return true;
                else vis[nr][nc] = false;
            }
        }
        return false;
    }
}