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
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int n){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(long q : query){
            long temp;
            int cnt=0;
            for(int ind=2; ind<=Math.sqrt(q); ind++){
                if(isPrime(ind)){
                    temp = ind*ind;
                    
                    if(temp <= q){
                        cnt++;
                    }
                }
            }    
            
            ans.add(cnt);
        }
    
        return ans;
        
    }
    
    static boolean isPrime(int ind){
        for(int inx=2; inx<=Math.sqrt(ind); inx++)
            if(ind%inx == 0)
                return false;
                
        return true;        
    }
}