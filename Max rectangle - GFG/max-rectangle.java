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
        int max = 0;
        
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(M[r][c] == 0)
                    arr[c] = 0;
                else
                    arr[c] += 1;
            }
            
            max = Math.max(max, findarea(arr, m));
        }
        
        return max;
    }
    
    public int findarea(int[] arr, int n){
        int[] pre, suff;
        
        pre = findNearestSmaller(0, n, 1, arr, n);
        suff = findNearestSmaller(n-1, -1, -1, arr, n);
        
        int temp, max = -1;
        for(int ind=0; ind<n; ind++){
            temp = (suff[ind]-pre[ind]-1)*arr[ind];
            max = Math.max(max, temp);
        }
        
        return max;
    }
    
    public int[] findNearestSmaller(int s, int e, int add, int[] arr, int n){
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        if(add<0){
            st.add(n);
        }
        else{
            st.add(-1);
        }
        
        for(int ind=s; ind!=e; ind += add){
            while(st.size()>1 && arr[st.peek()]>=arr[ind])
                st.pop();
            
            res[ind] = st.peek();    
            st.add(ind);    
        }
        
        return res;
    }
}