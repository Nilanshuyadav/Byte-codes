//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long countBits(long N) {
        // code here
        if(N<=1) return N;
        
        long x = (long)Math.floor(Math.log(N)/Math.log(2));
        long num = (long)Math.pow(2,x);
        
        return ((num/2)*x) + (N-num+1) + countBits(N-num);
    }
}
        
