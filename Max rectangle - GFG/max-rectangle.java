//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        int[] arr = new int[m];
        int max=0;
        
        for(int ind=0; ind<n; ind++){
            for(int i=0; i<m; i++){
                if(M[ind][i] == 0)
                    arr[i] = 0;
                else
                    arr[i] += M[ind][i];
            }
            
            max = Math.max(max, solve(arr));
        }
        
        return max;
    }
    
    public int solve(int[] arr){
        Stack<int[]> st = new Stack<>();
        int n = arr.length;
        
        int[] left = new int[n], right = new int[n];
        
        st.push(new int[]{-1, -1});
        for(int ind=0; ind<n; ind++){
            if(st.size()==1){
                left[ind] = st.peek()[0];
            }
            else{
                while(st.size()>1 && st.peek()[1]>=arr[ind])    st.pop();
                
                left[ind] = st.peek()[0];
            }
            
            st.push(new int[]{ind, arr[ind]});
        }
        
        st.clear();
        
        st.push(new int[]{n, -1});
        for(int ind=n-1; ind>=0; ind--){
            if(st.size()==1){
                right[ind] = st.peek()[0];
            }
            else{
                while(st.size()>1 && st.peek()[1]>=arr[ind])    st.pop();
                
                right[ind] = st.peek()[0];
            }
            
            st.push(new int[]{ind, arr[ind]});
        }
        
        
        int cnt=1;
        
        for(int ind=0; ind<n; ind++){
            cnt = Math.max(cnt, (right[ind]-left[ind]-1) * arr[ind]);
        }
        
        return cnt;
    }
}