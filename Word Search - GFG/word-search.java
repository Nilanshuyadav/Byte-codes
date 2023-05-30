//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    int[] r_arr={-1, 0, 1, 0}, c_arr={0, 1, 0, -1};
    
    public boolean isWordExist(char[][] board, String word)
    {
        int n = word.length();
        int row = board.length, col = board[0].length;
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(board[r][c] == word.charAt(0)){
                    board[r][c] = '*';
                    if(helper(r, c, board, row, col, word, 1))
                        return true;
                    board[r][c] = word.charAt(0);    
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(int r, int c, char[][] board, int row, int col, String word, int ind){
        int n = word.length();
        
        if(ind == n){
            return true;
        }
        
        int new_r, new_c;
        char ch = word.charAt(ind);
        
        for(int i=0; i<4; i++){
            new_r = r+r_arr[i];
            new_c = c+c_arr[i];
            
            if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || board[new_r][new_c]!=ch) continue;
            
            board[new_r][new_c] = '*';
            
            if(helper(new_r, new_c, board, row, col, word, ind+1)){
                board[new_r][new_c] = ch;
                
                return true;
            }
            
            board[new_r][new_c] = ch;
        }
        
        return false;
    }
}