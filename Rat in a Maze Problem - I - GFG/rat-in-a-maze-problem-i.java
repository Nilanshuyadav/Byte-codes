//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static int[] r_arr = {-1, 0, 1, 0},
          c_arr = {0, 1, 0, -1};
    static char[] dir = {'U', 'R', 'D', 'L'};
    
    static ArrayList<String> ans;
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        if(m[0][0] == 0)    return new ArrayList<>();
        
        ans = new ArrayList<>();
        
        solve(0, 0, n, m, new StringBuilder(""));
        
        return ans;
    }
    
    public static void solve(int r, int c, int n, int[][] m, StringBuilder sb){
        if(r==n-1 && c==n-1){
            ans.add(sb.toString());
            
            return;
        }
        
        int new_r, new_c;
        
        for(int ind=0; ind<4; ind++){
            new_r = r+r_arr[ind];
            new_c = c+c_arr[ind];
            
            if(new_r<0 || new_c<0 || new_r>=n || new_c>=n || m[new_r][new_c]==0)
                continue;
                
            sb.append(dir[ind]);
            m[r][c] = 0;
            solve(new_r, new_c, n, m, sb);
            sb.deleteCharAt(sb.length()-1);
            m[r][c] = 1;
        }
    }
}