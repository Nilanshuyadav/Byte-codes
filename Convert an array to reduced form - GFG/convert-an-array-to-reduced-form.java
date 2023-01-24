//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        Pair[] temp_arr = new Pair[n];
        
        for(int ind=0; ind<n; ind++){
            temp_arr[ind] = new Pair(arr[ind], ind);
        }
        
        Arrays.sort(temp_arr, (a,b) -> a.num-b.num);
        
        for(int ind=0; ind<n; ind++){
            arr[temp_arr[ind].ind] = ind;
        }
    }
}

class Pair{
    int num;
    int ind;
    
    public Pair(int num, int ind){
        this.num = num;
        this.ind = ind;
    }
}