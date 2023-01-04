//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maximum_profit(int n, int[][] intervals) {
        // code here
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]!=b[0])
                return a[0]-b[0];
            return a[1]-b[1];
            });
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(0, intervals, n, dp);    
    }
    
    public static int solve(int ind, int[][] intervals, int n, int[] dp){
        if(ind>=n)
            return 0;
            
        if(dp[ind] != -1)
            return dp[ind];
        
        int not_pick = solve(ind+1, intervals, n, dp);
        
        int next_ind = findNextInd(ind+1, intervals[ind][1], intervals, n);
        
        int pick = intervals[ind][2] + solve(next_ind, intervals, n, dp);
        
        return dp[ind] = Math.max(pick, not_pick);
    }
    
    public static int findNextInd(int ind, int prev_ind, int[][] intervals, int n){
        while(ind<n){
            if(intervals[ind][0]>=prev_ind)
                break;
            else
                ind++;
        }
        
        return ind;
    }
}
