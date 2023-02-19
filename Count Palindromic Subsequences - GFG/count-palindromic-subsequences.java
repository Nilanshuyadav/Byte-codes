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
        
        for(long[] ind : dp)
            Arrays.fill(ind, -1);
        
        return solve(0, n-1, str, dp);
    }
    
    long solve(int s, int e, String str, long[][] dp){
        if(s==e)
            return 1;
        else if(e<s)
            return 0;
            
        if(dp[s][e] != -1)
            return dp[s][e];
            
        return dp[s][e] = str.charAt(s)==str.charAt(e) ?
                            (solve(s+1, e, str, dp) + solve(s, e-1, str, dp) + 1)%mod :
                            (mod + solve(s+1, e, str, dp) + solve(s, e-1, str, dp) - solve(s+1, e-1, str, dp))%mod;
    }
}