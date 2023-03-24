//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        int[] fre = new int[26];
        int n = S.length();
        
        for(int ind=0; ind<n; ind++){
            fre[S.charAt(ind)-'a']++;
        }
        
        int i=0, j=n-1;
        boolean bool = true;
        StringBuilder sbi= new StringBuilder(""),
                        sbj = new StringBuilder("");
        while(i<=j){
            if(bool){
                if(fre[S.charAt(i)-'a'] > 1){
                    fre[S.charAt(i)-'a']--;
                    bool = false;
                }
                else{
                    sbi.append(S.charAt(i));
                }
                
                i++;
            }    
            else{
                if(fre[S.charAt(j)-'a'] > 1){
                    fre[S.charAt(j)-'a']--;
                    bool = true;
                }
                else{
                    sbj.append(S.charAt(j));
                }
                j--;
            }
        }
        
        return bool ? sbi.toString()+sbj.reverse().toString() :
                        sbj.toString()+sbi.reverse().toString();
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends