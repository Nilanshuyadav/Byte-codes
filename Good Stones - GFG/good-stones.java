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
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int goodStones(int n, int[] arr) {
        boolean[] vis = new boolean[n];
        Boolean[] bad_stones = new Boolean[n];
        
        for(int ind=0; ind<n; ind++){
            if(!vis[ind])
                solve(ind, arr, bad_stones, vis);
        }
        
        int cnt=0;
        for(int ind=0; ind<n; ind++)
            if(!bad_stones[ind])
                cnt++;
                
        return cnt;        
    }
    
    public static boolean solve(int ind, int[] arr, Boolean[] bad_stones, boolean[] vis){
        if(ind>=bad_stones.length || ind<0)
            return false;
        
        if(bad_stones[ind]!=null)
            return bad_stones[ind];
        
        if(vis[ind])
            return true;
        
        vis[ind] = true;    
            
        if(solve(ind+arr[ind], arr, bad_stones, vis))
            return bad_stones[ind] = true;
        
        return bad_stones[ind] = false;    
    }
}
        
