//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int M, int K, int[] b) {
       int max = 0, n = b.length;
       long pro = (long)M * K;
       
       if(n < pro)
        return -1;
       
       for(int ind : b){
           max = Math.max(max, ind);
       }
       
       long l=0, h=max, m;
       long min = max, temp;
       
       while(l<=h){
           m = l + (h-l)/2;
           
           temp = canWe(m, b, (long)K);
           
           if(M<=temp){
               min = Math.min(min, m);
               h = m-1;
           }
           else{
               l = m+1;
           }
       }
       
       return (int)min;
    }
    
    public static long canWe(long m, int[] b, long k){
        long cnt = 0, temp_k=0;
        
        for(int ind : b){
            if(ind <= m){
                temp_k++;
            }
            else{
                temp_k = 0;
            }
            
            if(temp_k == k){
                cnt++;
                temp_k = 0;
            }
        }
        
        return cnt;
    }
}