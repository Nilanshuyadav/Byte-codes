class Solution {
    int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
    
    public boolean exist(char[][] board, String word) {
        int row=board.length, col=board[0].length;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(board[r][c] == word.charAt(0)){
                    board[r][c] = '*';
                    
                    if(solve(r,c,1,board,word)){
                        return true;
                    }
                    
                    board[r][c] = word.charAt(0);
                }
            }
        }
        
        return false;
    }
    
    public boolean solve(int r, int c, int i, char[][] board, String word){
        if(i==word.length()){
            return true;
        }
        
        int new_r, new_c, row=board.length, col=board[0].length;
        boolean bool=false;
        
        for(int ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || board[new_r][new_c]!=word.charAt(i)){
                continue;
            }
            
            board[new_r][new_c] = '*';
            bool = bool || solve(new_r, new_c, i+1, board, word);
            board[new_r][new_c] = word.charAt(i);
        }
        
        return bool;
    }
}