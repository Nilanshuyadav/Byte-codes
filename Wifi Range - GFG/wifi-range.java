//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int n, String S, int X) 
    { 
        int cnt=0, i=0, j=n-1;
        
        for(int ind=0; ind<n; ind++){
             if(S.charAt(ind) != '1'){
                 cnt++;
             }
             else{
                 i = ind;
                 break;
             }
             
             if(cnt>X)
                return false;
        }
        
        cnt=0;
        for(int ind=n-1; ind>=0; ind--){
            if(S.charAt(ind) != '1'){
                cnt++;
            }
            else{
                j = ind;
                break;
            }
            
            if(cnt>X){
                return false;
            }
        }
        
        
        for(int ind=i; ind<=j; ind++){
            if(S.charAt(ind) != '1'){
                cnt++;
            }
            else{
                cnt=0;
            }
            
            if(cnt>(2*X)){
                return false;
            }
        }
        
        return true;
    }
} 