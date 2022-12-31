//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int start[] = new int[N];
            int end[] = new int[N];

            String inputLine2[] = br.readLine().trim().split(" ");
            String inputLine3[] = br.readLine().trim().split(" ");
            
            for (i = 0; i < N; i++) {
                start[i] = Integer.parseInt(inputLine2[i]);
                end[i] = Integer.parseInt(inputLine3[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minLaptops(N, start, end));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minLaptops(int N, int[] start, int[] end) {
        int n = start.length;
        
        int[][] arr = new int[n][2];
        
        for(int ind=0; ind<n; ind++){
            arr[ind][0] = start[ind];
            arr[ind][1] = end[ind];
        }
        
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(Integer.MAX_VALUE);
        
        int start_time=0, cnt=0;
        
        for(int ind=0; ind<n; ind++){
            start_time = arr[ind][0];
            
            if(start_time>=pq.peek()){
                pq.remove();
                pq.add(arr[ind][1]);
                
                continue;
            }
            
            else{
                pq.add(arr[ind][1]);
                cnt++;
            }
        }
        
        return cnt;
    }
}