//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    ArrayList<String> ans;
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        int n = S.length();
        boolean[] vis = new boolean[n];
        ans = new ArrayList<>();
        
        solve(0, n, new StringBuilder(""), S, vis);
        
        Collections.sort(ans);
        
        return ans;
    }
    
    public void solve(int ind, int n, StringBuilder sb, String s, boolean[] vis){
        if(ind == n){
            ans.add(sb.toString());
            return;
        }
        
        for(int i=0; i<n; i++){
            if(!vis[i]){
                vis[i] = true;
                sb.append(s.charAt(i));
                
                solve(ind+1, n, sb, s, vis);
                
                vis[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
	   
}
