//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        //code here
        int[][] arr = new int[n][n];
        int max = 100000000;
        
        for(int[] ind : arr)
            Arrays.fill(ind, max);
        
        for(int ind=0; ind<n; ind++)
            arr[ind][ind] = 0;
        
        for(int[] ind : edges){
            arr[ind[0]][ind[1]] = ind[2];
            arr[ind[1]][ind[0]] = ind[2];
        }
        
        for(int via=0; via<n; via++){
            for(int r=0; r<n; r++){
                for(int c=0; c<n; c++){
                    int temp = Math.min(max, arr[r][via] + arr[via][c]);
                    arr[r][c] = Math.min(arr[r][c], temp);
                }
            }
        }
        
        int[] ans = new int[n];
        
        for(int ind=0; ind<n; ind++){
            int cnt=0;
            for(int c=0; c<n; c++){
                if(ind == c) continue;
                if(arr[ind][c] <= distanceThreshold)
                    cnt++;
            }
            
            ans[ind] = cnt;
        }
        
        int result = 0, min = Integer.MAX_VALUE;
        
        for(int ind=0; ind<n; ind++){
            if(ans[ind] <= min){
                min = ans[ind];
                result = ind;
            }    
        }
        
        return result;
    }
}
