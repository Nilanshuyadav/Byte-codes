//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	    int r1=0, r2=n-1, c1=0, c2=m-1;
	    int ind;
	    
	    while(r1<=r2 && c1<=c2){
	        ind=c1;
	        while(ind<=c2){
	            k--;
	            
	            if(k==0) return a[r1][ind];
	            ind++;
	        }
	        
	        ind=r1+1;
	        while(ind<=r2){
	            k--;
	            
	            if(k==0) return a[ind][c2];
	            ind++;
	        }
	        
	        ind=c2-1;
	        while(r1!=r2 && c1<ind){
	            k--;
	            
	            if(k==0) return a[r2][ind];
	            ind--;
	        }
	        
	        ind=r2;
	        while(c1!=c2 && ind>r1){
	            k--;
	            
	            if(k==0) return a[ind][c1];
	            ind--;
	        }
	        
	        r1++;
	        c1++;
	        r2--;
	        c2--;
	    }
	    
	    return -1;
	}
	
}