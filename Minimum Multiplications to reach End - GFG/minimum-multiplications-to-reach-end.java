//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int[] ans = new int[100000];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(start,0));
        
        while(!q.isEmpty()){
            Pair t = q.remove();
            
            for(int ind : arr){
                long temp = (t.ind * ind);
                int i = (int)(temp%100000);
                
                if(ans[i] > t.step+1){
                    ans[i] = t.step+1;
                    q.add(new Pair(i, t.step+1));
                }
            }
        }
        
        return ans[end]==Integer.MAX_VALUE?-1:ans[end];
    }
}


class Pair{
    int ind;
    int step;
    public Pair(int ind, int step){
        this.ind = ind;
        this.step = step;
    }
}