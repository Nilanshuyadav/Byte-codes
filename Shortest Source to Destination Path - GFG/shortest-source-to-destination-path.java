//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] r_arr={-1,0,1,0}, c_arr={0,1,0,-1};
    
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if(A[0][0]==0 || A[X][Y]==0) return -1;
        if(X==0 && Y==0) return 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{X, Y});
        
        int size, cnt=0, new_r, new_c, r, c, row=A.length, col=A[0].length, temp[];
        boolean[][] vis = new boolean[row][col];
        vis[X][Y] = true;
        
        while(!q.isEmpty()){
            size = q.size();
            cnt++;
            
            while(size-->0){
                temp = q.remove();
                
                r = temp[0];
                c = temp[1];
                
                for(int ind=0; ind<4; ind++){
                    new_r = r+r_arr[ind];
                    new_c = c+c_arr[ind];
                    
                    if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || A[new_r][new_c]!=1)
                        continue;
                    
                    if(new_r==0 && new_c==0){
                        return cnt;
                    }
                    
                    if(!vis[new_r][new_c]){
                        vis[new_r][new_c] = true;
                        q.add(new int[]{new_r, new_c});
                    }
                }    
            }
        }
        
        return -1;
    }
};