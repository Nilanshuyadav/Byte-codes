//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N) {
        // code here
        if(isPrime(N)) return N;
        
        int max=1, fac1, fac2;
        
        for(int i=2; i<=(int)Math.sqrt(N)+1; i++){
            if(N%i == 0){
                fac1 = i;
                fac2 = N/i;
                
                if(isPrime(fac1)){
                    max = Math.max(max, fac1);
                }
                
                if(isPrime(fac2)){
                    max = Math.max(max, fac2);
                }
            }
        }
        
        return max;
    }
    
    static boolean isPrime(int n){
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        
        return true;
    }
}