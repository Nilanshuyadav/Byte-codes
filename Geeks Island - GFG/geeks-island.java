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
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int water_flow(int [][] mat, int N, int M) {
		boolean[][] arabian_sea = new boolean[N][M], indian_ocean = new boolean[N][M];
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int r=0; r<N; r++){
		    arabian_sea[r][M-1] = true;
		    q.add(new int[]{r, M-1});
		    
		    if(r==N-1)
		        for(int c=0; c<M-1; c++){
		            arabian_sea[r][c] = true;
		            q.add(new int[]{r,c});
		        }
		}
		
		int temp[], row, col, new_r, new_c, r_arr[]={-1,0,1,0}, c_arr[]={0,1,0,-1};
		while(!q.isEmpty()){
		    temp = q.remove();
		    
		    row = temp[0];
		    col = temp[1];
		    
		    for(int ind=0; ind<4; ind++){
		        new_r = row+r_arr[ind];
		        new_c = col+c_arr[ind];
		        
		        if(new_r<0 || new_c<0 || new_r>=N || new_c>=M || mat[new_r][new_c]<mat[row][col] || arabian_sea[new_r][new_c])
		            continue;
		            
		        arabian_sea[new_r][new_c] = true;
		        q.add(new int[]{new_r, new_c});
		    }
		}
		
		
		
		for(int r=0; r<N; r++){
		    indian_ocean[r][0] = true;
		    q.add(new int[]{r, 0});
		    
		    if(r==0)
		        for(int c=1; c<M; c++){
		            indian_ocean[r][c] = true;
		            q.add(new int[]{r,c});
		        }
		}
		
		
		while(!q.isEmpty()){
		    temp = q.remove();
		    
		    row = temp[0];
		    col = temp[1];
		    
		    for(int ind=0; ind<4; ind++){
		        new_r = row+r_arr[ind];
		        new_c = col+c_arr[ind];
		        
		        if(new_r<0 || new_c<0 || new_r>=N || new_c>=M || mat[new_r][new_c]<mat[row][col] || indian_ocean[new_r][new_c])
		            continue;
		            
		        indian_ocean[new_r][new_c] = true;
		        q.add(new int[]{new_r, new_c});
		    }
		}
		
		int cnt=0;
		
		for(int r=0; r<N; r++){
		    for(int c=0; c<M; c++){
		        if(indian_ocean[r][c] && arabian_sea[r][c])
		            cnt++;
		    }
		}
		
		return cnt;
	}
}