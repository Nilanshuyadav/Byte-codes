//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leafNodes(int arr[], int N)
    {
        Stack<Integer> st = new Stack<>();
        List<Integer> al = new ArrayList<>();
        
        for(int ind : arr){
            if(st.size() == 0) st.add(ind);
            else if(st.peek() < ind){
                int temp = st.peek();
                int cnt=0;
                
                while(st.size()>0 && st.peek()<ind){
                    cnt++;
                    st.pop();
                }
                
                if(cnt > 1)
                    al.add(temp);
                    
                st.add(ind);    
            }
            
            else st.add(ind);
        }
        
        al.add(st.peek());
        
        int[] ans = new int[al.size()];
        int k=0;
        
        for(int ind : al)
            ans[k++] = ind;
        
        return ans;
    }
}