//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        int max=0, temp=0, temp2, ro[]=new int[N], co[]=new int[N];
        
        for(int r=0, c2=0; r<N; r++, c2++){
            temp = 0;
            temp2 = 0;
            
            for(int c=0, r2=0; c<N; c++, r2++){
                temp += matrix[r][c];
                temp2 += matrix[r2][c2];
            }
            
            ro[r] = temp;
            co[c2] = temp2;
            
            max = Math.max(max, temp);
            max = Math.max(max, temp2);
        }
        
        for(int ind=0; ind<N; ind++){
            ro[ind] = max-ro[ind];
            co[ind] = max-co[ind];
        }
        
        int cnt=0, min;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                min = Math.min(ro[r], co[c]);
                
                cnt += min;
                ro[r] -= min;
                co[c] -= min;
            }
        }
        
        return cnt;
    }
}
        
