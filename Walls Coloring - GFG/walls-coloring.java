//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int N){
        int[][] dp = new int[N][3];
        
        for(int ind=0; ind<3; ind++)
            dp[0][ind] = colors[0][ind];
            
        int min;    
        for(int r=1; r<N; r++){
            for(int c=0; c<3; c++){
                min = Integer.MAX_VALUE;
                if(c==0)
                    min = Math.min(dp[r-1][1], dp[r-1][2]);
                else if(c==1)
                    min = Math.min(dp[r-1][0], dp[r-1][2]);
                else
                    min = Math.min(dp[r-1][0], dp[r-1][1]);
                    
                min += colors[r][c];
                
                dp[r][c] = min;
            }
        }    
        
        return Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
    }
}