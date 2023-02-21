//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
	    
		int cnt=-1;
		Queue<int[]> q = new LinkedList<>();
		
		boolean[][] arr = new boolean[N][M];
		
		arr[x-1][y-1] = true;
		
		q.add(new int[]{x-1,y-1});
		
		int size, r, c, new_r, new_c, temp[], r_arr[]={-1,0,1,0}, c_arr[]={0,1,0,-1};
		
		while(!q.isEmpty()){
		    size = q.size();
		    
		    cnt++;
		    while(size-->0){
		        temp = q.remove();
		        
		        r = temp[0];
		        c = temp[1];
		        
		        for(int ind=0; ind<4; ind++){
		            new_r = r+r_arr[ind];
		            new_c = c+c_arr[ind];
		            
		            if(new_r<0 || new_c<0 || new_r>=N || new_c>=M || arr[new_r][new_c]) continue;
		            
		            arr[new_r][new_c] = true;
		            q.add(new int[]{new_r, new_c});
		        }
		    }
		}
		
		return cnt;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends