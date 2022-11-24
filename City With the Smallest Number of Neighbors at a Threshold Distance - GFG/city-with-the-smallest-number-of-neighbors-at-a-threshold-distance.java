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
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int[] ind : edges){
            adj.get(ind[0]).add(new int[]{ind[1], ind[2]});
            adj.get(ind[1]).add(new int[]{ind[0], ind[2]});
        }
        int ans=-1, min=n, cnt=0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new my_comparator());
        int[] arr = new int[n];
        int max = (int)1e8;
        
        for(int ind=0; ind<n; ind++){
            q.add(new int[]{ind, 0});
    
            Arrays.fill(arr, max);
            arr[ind] = 0;
            
            cnt=0;
          
            while(!q.isEmpty()){
                int size = q.size();
                
                while(size-->0){
                    int[] temp = q.remove();
                    
                    if(temp[1] == distanceThreshold)
                        continue;
                    
                    for(int[] inx : adj.get(temp[0])){
                        int pre = temp[1]+inx[1];
                        
                        if(pre<=distanceThreshold && pre<arr[inx[0]]){
                            q.add(new int[]{inx[0], temp[1]+inx[1]});
                        
                            if(arr[inx[0]] == max)
                                cnt++;
                            
                            arr[inx[0]] = pre;    
                        }    
                    }
                }
            }
        
            if(cnt <= min){
                min = cnt;
                ans = ind;
            }
        }
        
        return ans;
    }    
}


class my_comparator implements Comparator<int[]>{
    public int compare(int[] a1, int[] a2){
        return a1[1] - a2[1];
    }
}