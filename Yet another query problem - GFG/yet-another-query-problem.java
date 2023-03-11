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
            
            
            int num;
            num = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[][] Q = IntMatrix.input(br, num, 3);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.solveQueries(N, num, A, Q);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> solveQueries(int N, int num, int[] A, int[][] Q) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int ind=0; ind<N; ind++){
            if(!map.containsKey(A[ind])){
                map.put(A[ind], new ArrayList<>());
            }
            
            map.get(A[ind]).add(ind);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int from, to, k, cnt=0, fre;
        
        for(int ind[] : Q){
            from=ind[0];
            to=ind[1];
            k=ind[2];
            
            cnt=0;
            
            for(int i=from; i<=to; i++){
                fre = freFromIndex(A[i], i, map);
                
                if(fre==k)
                    cnt++;
            }
            
            ans.add(cnt);
        }
        
        return ans;
    }
    
    public static int freFromIndex(int element, int index,  Map<Integer, List<Integer>> map){
        List<Integer> temp = map.get(element);
        int size = temp.size();
        
        int pos = findPos(temp, index, size);
        
        return size-pos;
    }
    
    public static int findPos(List<Integer> temp, int index, int size){
        int l=0, h=size-1, m;
        
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(temp.get(m) == index) return m;
            else if(temp.get(m) < index) l=m+1;
            else h=m-1;
        }
        
        return -1;
    }
}
        
