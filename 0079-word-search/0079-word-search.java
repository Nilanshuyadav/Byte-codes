class Solution {
    int[] r_arr = {-1,0,1,0}, c_arr = {0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length, n=word.length();
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == word.charAt(0) && find(i, j, 1, word, n, row, col, board)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean find(int r, int c, int ind, String word, int n, int row, int col, char[][] board){
        if(ind == n)    return true;
        
        char ch = word.charAt(ind);
        int new_r, new_c;
        
        board[r][c] = '*';  
        
        for(int inx=0; inx<4; inx++){
            new_r = r + r_arr[inx];
            new_c = c + c_arr[inx];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || board[new_r][new_c]!=ch) continue;
            
            if(find(new_r, new_c, ind+1, word, n, row, col, board))
                return true;
        }
        
        board[r][c] = word.charAt(ind-1);
        return false;
    }
}