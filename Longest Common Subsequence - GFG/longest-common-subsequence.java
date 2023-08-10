//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int[] pre = new int[y+1], curr = new int[y+1];
        char ch1, ch2;
        
        for(int i=0; i<x; i++){
            ch1 = s1.charAt(i);
            
            for(int j=1; j<=y; j++){
                ch2 = s2.charAt(j-1);
                
                if(ch1==ch2){
                    curr[j] = pre[j-1]+1;
                }
                else{
                    curr[j] = Math.max(curr[j-1], pre[j]);
                }
            }
            
            for(int ind=0; ind<=y; ind++){
                pre[ind] = curr[ind];
            }
        }
        
        return pre[y];
    }
    
}