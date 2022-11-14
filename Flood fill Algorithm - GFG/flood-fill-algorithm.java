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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int row = image.length;
        int col = image[0].length;
        
        int[] r_arr = {-1,0,1,0}, c_arr = {0,1,0,-1};
        
        if(image[sr][sc] == newColor) return image;
        
        int present_color = image[sr][sc];
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = newColor;
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int ind=0; ind<4; ind++){
                int new_row = temp.row+r_arr[ind];
                int new_col = temp.col+c_arr[ind];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || image[new_row][new_col]!=present_color)
                    continue;
                
                image[new_row][new_col] = newColor;
                q.add(new Pair(new_row, new_col));
            }
        }
        
        return image;
    }
}

class Pair{
    int row, col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}