//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int H) {
        int max = 0;
        for(int ind=0; ind<N; ind++){
            max = Math.max(max, piles[ind]);
        }
        
        int l=1, h=max, m, temp, min=max;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            temp = helper(piles, m);
            
            if(temp <= H){
                min = Math.min(min, m);
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        return min;
    }
    
    public static int helper(int[] piles, int m){
        int cnt=0;
        
        for(int ind : piles){
            cnt += ((ind-1)/m)+1;
        }
        
        return cnt;
    }
}
        
