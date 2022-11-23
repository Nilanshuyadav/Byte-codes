//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.maxSumLCM(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long maxSumLCM(int n) {
        // code here
        long ans = 0;
        int temp = (int)Math.sqrt(n);
        
        for(int ind=1; ind<=temp; ind++){
            if(n%ind == 0){
                ans += n/ind;
                
                if(ind != n/ind)
                    ans += ind;
            }    
        }
        
        return ans;        
    }
}