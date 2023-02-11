//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        int pair = 0;
        
        for(int ind=1; ind<N; ind++){
            if(S.charAt(ind)==S.charAt(ind-1))
                pair++;
        }
        
        if(pair==0)
            return 0;
            
        StringBuilder sb = new StringBuilder(S);    
        
        int days=0, index;
        for(int ind=0; ind<N; ind++){
            index = P[ind];
            days++;
            
            if(index!=0 && sb.charAt(index)==sb.charAt(index-1))
                pair--;
            if(index!=N-1 && sb.charAt(index)==sb.charAt(index+1))
                pair--;
                
            sb.setCharAt(index, '?');
            
            if(pair==0)
                return days;
        }
        
        return -1;
    }
}
        
