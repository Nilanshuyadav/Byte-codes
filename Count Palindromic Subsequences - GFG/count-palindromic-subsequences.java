//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    int mod = 1000000007;
    long countPS(String str)
    {
        int n = str.length();
        
        long[][] dp = new long[n][n];
        
        for(long ind[] : dp)
            Arrays.fill(ind, -1);
            
        return solve(0, n-1, str, dp);
    }
    
    long solve(int i, int j, String st, long[][] dp){
        if(i==j)
            return 1;
        if(j<i)
            return 0;
            
        if(dp[i][j] != - 1)
            return dp[i][j];
            
        return dp[i][j] = st.charAt(i)==st.charAt(j)?
                            (solve(i+1, j, st, dp) + solve(i, j-1, st, dp) + 1)%mod :
                            (mod + solve(i+1, j, st, dp) + solve(i, j-1, st, dp) - solve(i+1, j-1, st, dp))%mod;
    }
}