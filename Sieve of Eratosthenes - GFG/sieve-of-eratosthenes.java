//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        boolean[] not_prime = new boolean[N+1];
        
        for(int ind=2; ind*ind<=N; ind++){
            if(!not_prime[ind]){
                for(int i=ind*ind; i<=N; i+=ind)
                    not_prime[i] = true;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ind=2; ind<=N; ind++)
            if(!not_prime[ind])
                ans.add(ind);
                
        return ans;        
    }
}