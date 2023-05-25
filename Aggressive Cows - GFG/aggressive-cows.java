//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        int min=(int)1e8, max = -1;
        for(int ind : stalls){
            min = Math.min(min, ind);
            max = Math.max(max, ind);
        }
        
        Arrays.sort(stalls);
        
        int l=1, h=max-min, m, temp, ans=-1;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            temp = canWe(m, stalls);
            
            if(k<=temp){
                ans = Math.max(ans, m);
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return ans;
    }
    
    public static int canWe(int m, int[] stalls){
        int cnt=0, pre=stalls[0];
        
        for(int ind : stalls){
            if(m <= ind-pre){
                cnt++;
                pre = ind;
            }
        }
        
        return cnt+1;
    }
}