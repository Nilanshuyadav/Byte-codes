class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for(char[] i : board){
            Arrays.fill(i,'.');
        }
        
        function(0,board,ans);
        
        return ans;
    }
    
    public void function(int col, char[][] board, List<List<String>> ans){
       if(col == board.length){
           ans.add(construct(board));
           return;
       } 
        
       for(int row = 0;row<board.length;row++){
           if(isValid(row,col,board)){
               board[row][col] = 'Q';
               function(col+1,board,ans);
               board[row][col] = '.';
           }
       } 
    }
    
    public boolean isValid(int row,int col,char[][] board){
        int duplicate_row = row, duplicate_col = col;
        
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
            row--;
        }
        
        col = duplicate_col;
        row = duplicate_row;
        
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        
        while(duplicate_row<board.length && duplicate_col>=0){
            if(board[duplicate_row][duplicate_col] == 'Q') return false;
            duplicate_col--;
            duplicate_row++;
        }
        
        return true;
    }
    
    public List<String> construct(char[][] board){
        List<String> s = new ArrayList<>();
        
        for(char[] i : board){
            String str = new String(i);
            s.add(str);
        }
        
        return s;
    }
}