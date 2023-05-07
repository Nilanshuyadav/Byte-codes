//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        int max = 0, curr=0;
        
        if(m==0){
            for(int ind : arr){
                if(ind == 1){
                    curr++;
                }
                else{
                    max = Math.max(max, curr);
                    curr=0;
                }
            }
            max = Math.max(max, curr);
            
            return max;
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        int pre = -1;
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind] == 0){
                q.add(ind);
                
                if(q.size() > m){
                    pre = q.poll();
                }
            }
            
            max = Math.max(max, ind-pre);
        }
        
        return max;
    }
}