//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        long ans=0, pro=1;
        int i=0, j=0, pre=-1, len;
        
        if(k == 1){
            return 0;
        }
        
        while(j<n){
            pro *= a[j];
            
            if(pro >= k){
                len = j-i;
                
                ans += ((len)*(len+1))/2;
                
                if(i<=pre){
                    len = pre-i+1;
                    
                    ans -= ((len)*(len+1))/2;
                }
                
                pre = j-1;
                
                while(pro >= k){
                    pro /= a[i++];
                }
            }
            
            j++;
        }
        
        len = j-i;
        
        ans += ((len)*(len+1))/2;
        
        if(i<=pre){
            len = pre-i+1;
            
            ans -= ((len)*(len+1))/2;
        }
        
        return (int)ans;
    }
}