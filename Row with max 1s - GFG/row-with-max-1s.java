//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int ans=-1, pos, max=-1;
        
        for(int i=0; i<n; i++){
            pos = findPos(arr[i], m, 1);
            
            if(m-pos > max){
                max = m-pos;
                ans = i;
            }
            
            if(m == max)  return ans;
        }
        
        return ans;
    }
    
    int findPos(int[] arr, int col, int target){
        int l=0, h=col-1, m, min = col+1;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(arr[m] == target){
                min = Math.min(min, m);
                h = m-1;
            }
            else if(arr[m] < target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return min;
    }
}