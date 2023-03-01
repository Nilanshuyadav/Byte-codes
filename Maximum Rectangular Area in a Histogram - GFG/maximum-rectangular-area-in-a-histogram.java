//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        long[] suff, pre;
        
        pre = findNearestSmaller(0, (int)n, 1, hist, n);
        suff = findNearestSmaller((int)n-1, -1, -1, hist, n);
        
        long ans = Integer.MIN_VALUE, temp;
        
        for(int ind=0; ind<n; ind++){
            temp = (suff[ind] - pre[ind] - 1)*hist[ind];
            ans = Math.max(ans, temp);
        }
        
        return ans;
    }
    
    public static long[] findNearestSmaller(int s, int e, int add, long[] hist, long n){
        long[] arr = new long[(int)n];
        
        Stack<long[]> st = new Stack<>();
        if(add<0)
            st.add(new long[]{n,-1});
        else
            st.add(new long[]{-1, -1});
        
        for(int ind=s; ind!=e; ind += add){
            while(st.size()>1 && st.peek()[1]>=hist[ind]){
                st.pop();
            }
            
            arr[ind] = st.peek()[0];
            st.add(new long[]{ind, hist[ind]});
        }
        
        return arr;
    }
        
}



