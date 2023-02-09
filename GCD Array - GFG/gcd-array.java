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
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int K;
            K = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.solve(N, K, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int solve(int N, int K, int[] arr) {
        int total = 0;
        
        for(int ind : arr)
            total += ind;
            
        List<Integer> factors = findFactor(total);
        
        int[] pre = new int[N];
        pre[0] = arr[0];
        
        for(int ind=1; ind<N; ind++){
            pre[ind] = pre[ind-1]+arr[ind];
        }
        
        int max = 0;
        
        for(int ind : factors){
            int temp_=0;
            
            for(int inx=0; inx<N; inx++){
                if(pre[inx]%ind==0)
                    temp_++;
            }
            
            if(temp_>=K){
                max = Math.max(max, ind);
            }
        }    
        
        return max;
    }
    
    public static List<Integer> findFactor(int total){
        List<Integer> al = new ArrayList<>();
        
        int root = (int)Math.sqrt(total)+1;
        
        for(int ind=1; ind<root; ind++){
            if(total%ind==0){
                al.add(ind);
                al.add(total/ind);
            }
        }
        
        return al;
    }
}