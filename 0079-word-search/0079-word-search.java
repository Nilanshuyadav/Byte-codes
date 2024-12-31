class Solution {
    int[] r_arr = {-1, 0, 1, 0}, c_arr = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean ans = false;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(board[r][c] == word.charAt(0)){
                    board[r][c] = '*';
                    ans = ans || helper(r, c, row, col, board, word, 1, word.length());
                    board[r][c] = word.charAt(0);
                }
            }
        }

        return ans;
    }

    public boolean helper(int r, int c, int row, int col, char[][] board,  String word, int ind, int n){
        if(ind == n){
            return true;
        }

        int new_r, new_c;
        char curr = board[r][c];
        boolean ans = false;

        for(int i=0; i<4; i++){
            new_r = r+r_arr[i];
            new_c = c+c_arr[i];

            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || board[new_r][new_c]=='*' || board[new_r][new_c]!=word.charAt(ind)) continue;
            curr = board[new_r][new_c];
            board[new_r][new_c] = '*';

            ans = ans || helper(new_r, new_c, row, col, board, word, ind+1, n);

            board[new_r][new_c] = curr;
        }

        return ans;
    }
}