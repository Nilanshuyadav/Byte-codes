//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int ind=1; ind<=N; ind++){
            dq.add(ind);
        }
        
        boolean bool = false;
        int temp_k = K;
        while(dq.size()>0){
            temp_k = K;
            
            if(!bool){
                while(temp_k-->0){
                    if(dq.size()==1){
                        return dq.removeFirst();
                    }
                    
                    dq.removeFirst();
                }
                
                bool = true;
            }
            else{
                while(temp_k-->0){
                    if(dq.size()==1){
                        return dq.removeFirst();
                    }
                    
                    dq.removeLast();   
                }
                
                bool = false;
            }
        }
        
        return -1;
    }
}