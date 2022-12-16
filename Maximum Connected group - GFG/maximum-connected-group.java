//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    int[] parent, size;
    public int MaxConnection(int grid[][]) {
        int row = grid.length, col = grid[0].length;
        int n = row*col;
        
        int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
        
        parent = new int[n];
        size = new int[n];
        
        for(int ind=0; ind<n; ind++){
            parent[ind] = ind;
            size[ind] = 1;
        }
            
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 1){
                    for(int inx=0; inx<4; inx++){
                        int new_r = r+r_arr[inx];
                        int new_c = c+c_arr[inx];
                        
                        if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || grid[new_r][new_c]!=1)
                            continue;
                            
                        int parent_main = findPar((r*col)+c);
                        int parent_temp = findPar((new_r*col)+new_c);
                        
                        if(parent_main != parent_temp){
                            union(parent_main, parent_temp);
                        }
                    }
                }
            }
        }
        
        int sum=0, max=0;
        
        for(int ind=0; ind<n; ind++){
            max = Math.max(max, size[ind]);
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                sum = 0;
                if(grid[r][c] == 0){
                    for(int inx=0; inx<4; inx++){
                        int new_r = r+r_arr[inx];
                        int new_c = c+c_arr[inx];
                        
                        if(new_r<0 || new_c<0 || new_r>=row || new_c>=col)
                            continue;
                        
                        if(grid[new_r][new_c] == 1){
                            
                            int parent_temp = findPar((new_r*col)+new_c);
                            
                            if(set.add(parent_temp)){
                                sum += size[parent_temp];
                            }
                        }                    
                    }
                    
                    max = Math.max(max, sum+1);
                    set.clear();
                }
            }
        }    
        
        return max;
    }
    
    public int findPar(int node){
        if(parent[node] == node)
            return node;
        
        return parent[node] = findPar(parent[node]);    
    }
    
    public void union(int a_par, int b_par){
        if(size[a_par]<=size[b_par]){
            parent[a_par] = b_par;
            size[b_par] += size[a_par];
        }
        else{
            parent[b_par] = a_par;
            size[a_par] += size[b_par];
        }
    }
    
}