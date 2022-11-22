//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
        int row = heights.length, col = heights[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new my_comparator());
        int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
        
        int[][] dist = new int[row][col];
        for(int ind[] : dist)
            Arrays.fill(ind, Integer.MAX_VALUE);
            
        pq.add(new int[]{0,row-1,col-1});
        dist[row-1][col-1] = 0;
        
        while(!pq.isEmpty()){
            int[] temp = pq.remove();
            
            int d = temp[0];
            int r = temp[1];
            int c = temp[2];
            
            for(int ind=0; ind<4; ind++){
                int new_row = r+r_arr[ind];
                int new_col = c+c_arr[ind];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col)
                    continue;
                    
                int max = Math.max(d, Math.abs(heights[r][c] - heights[new_row][new_col]));
                
                if(dist[new_row][new_col] > max){
                    pq.add(new int[]{max, new_row, new_col});
                    dist[new_row][new_col] = max;
                }
            
            }
        }
        
        return dist[0][0];
    }
}

class my_comparator implements Comparator<int[]>{
    public int compare(int[] a1, int[] a2){
        return a1[0] - a2[0];
    }
}