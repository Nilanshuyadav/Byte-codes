//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int cuts(String s)
    {
        // code here
        if(s.charAt(0) == '0')  return -1;
        
        int n = s.length(), temp = solve(0, n-1, s);
        return temp==(int)1e8 ? -1 : temp;
    }
    
    static int solve(int s, int e, String st){
        if(isPower(s,e,st)){
            return 1;
        }
        
        
        int temp;
        for(int ind=e-1; ind>=s; ind--){
            if(st.charAt(ind+1)=='1' && isPower(s, ind, st)){
                temp = solve(ind+1, e, st);
                
                if(temp<(int)1e8){
                    return temp+1;
                }
            }
        }
        
        return (int)1e8;
    }
    
    static boolean isPower(int s, int e, String st){
        long num = Long.parseLong(st.substring(s,e+1),2);
        
        double power = (float)(Math.log(num)/Math.log(5));
        int temp_power = (int)(power);
        
        return power == temp_power;
    }
}


