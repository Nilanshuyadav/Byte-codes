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
    int mod;
    long countPS(String str)
    {
        mod = 1000000007;
        int n = str.length();
        long[][] dp = new long[n][n];
        
        for(long ind[] : dp)
            Arrays.fill(ind, Integer.MIN_VALUE);
        
        return solve(0, str.length()-1, str, dp);
    }
    
    long solve(int i, int j, String str, long[][] dp){
        if(j<=i)
            return j<i?0:1;
            
        if(dp[i][j] != Integer.MIN_VALUE)    
            return dp[i][j];
            
        return dp[i][j] = str.charAt(i)==str.charAt(j)? (solve(i+1, j, str, dp) + solve(i, j-1, str, dp) + 1)%mod : (mod + solve(i+1, j, str, dp) + solve(i, j-1, str, dp) - solve(i+1, j-1, str, dp))%mod;    
    }
}