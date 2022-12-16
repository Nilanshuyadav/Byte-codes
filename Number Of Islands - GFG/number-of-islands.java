//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    int[] parent, rank;
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        parent = new int[rows*cols];
        rank = new int[rows*cols];
        
        int[][] matrix = new int[rows][cols];
        
        Arrays.fill(parent,-1);
            
        List<Integer> res = new ArrayList<>();
        
        int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
        int islands=0;
        
        for(int ind[] : operators){
            int temp_row = ind[0];
            int temp_col = ind[1];
            
            if(matrix[temp_row][temp_col] == 1){
                res.add(islands);
                continue;
            }
            
            islands++;
            
            matrix[temp_row][temp_col] = 1;
            parent[((temp_row)*cols)+temp_col] = ((temp_row)*cols)+temp_col;
            
            for(int inx=0; inx<4; inx++){
                int new_r = temp_row+r_arr[inx];
                int new_c = temp_col+c_arr[inx];
                
                if(new_r<0 || new_c<0 || new_r>=rows || new_c>=cols)
                    continue;
                
                if(matrix[new_r][new_c] == 1){
                    
                    int parent_main = findPar((temp_row*cols)+temp_col);
                    int parent_new = findPar((new_r*cols)+new_c);
                    
                    if(parent_main != parent_new){
                        islands--;
                        union(parent_main, parent_new);
                    }
                }
            }
            
            res.add(islands);
        }
        
        return res;
    }
    
    public int countPar(){
        int cnt=0;
        
        for(int ind=0; ind<parent.length; ind++)
            if(parent[ind] == -1)
                continue;
            else if(parent[ind] == ind)
                cnt++;
                
        return cnt;        
    }
    
    public int findPar(int a){
        if(parent[a] == a)
            return a;
        return parent[a] = findPar(parent[a]);    
    }
    
    public void union(int a_par, int b_par){
        if(rank[a_par]<rank[b_par])
            parent[a_par] = b_par;
        else if(rank[b_par]<rank[a_par])
            parent[b_par] = a_par;
        else{
            parent[a_par] = b_par;
            rank[b_par]++;
        }    
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends