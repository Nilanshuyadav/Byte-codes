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
        Arrays.sort(stalls);
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for(int ind : stalls){
            max = Math.max(max, ind);
            min = Math.min(min, ind);
        }
        
        int l=0, h=max-min, m, ans=0;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(canWe(stalls, n, k, m)) {ans=m; l=m+1;}
            else h=m-1;
        }
        
        return ans;
    }
    
    public static boolean canWe(int[] stalls, int n, int k, int m){
        int cnt=1;
        int i=0, pos;
        
        while(i<n){
            pos = findPos(stalls[i]+m, stalls, n);
            
            if(pos>=n) break;
            
            cnt++;
            i = pos;
            
            if(cnt>=k) return true;
        }
        
        return cnt>=k;
    }
    
    public static int findPos(int target, int[] stalls, int n){
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(stalls[m] == target) return m;
            else if(stalls[m] < target) l=m+1;
            else h=m-1;
        }
        
        return h+1;
    }
}