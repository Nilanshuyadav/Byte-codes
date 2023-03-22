//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    Stack<Integer> st = new Stack<>();
	    long cnt=0;
	    long ans=0;
	    int n = S.length();
	    
	    StringBuilder sb = new StringBuilder("");
	    boolean[] vis = new boolean[n];
	    char ch;
        
        if(X>Y){
            for(int ind=0; ind<n; ind++){
                ch = S.charAt(ind);
                
                if(ch!='p' && ch!='r'){
                    st.clear();
                    continue;
                }
                else if(ch=='p'){
                    st.add(ind);
                }
                else if(!st.isEmpty()){
                    cnt++;
                    vis[st.pop()] = true;
                    vis[ind] = true;
                }
            }    
            
            st.clear();
            
            ans += (X*cnt);
            cnt=0;
            
            for(int ind=0; ind<n; ind++){
                if(!vis[ind]){
                    sb.append(S.charAt(ind));
                }
            }
            
            
            for(int ind=0; ind<sb.length(); ind++){
                ch = sb.charAt(ind);
                
                if(ch!='p' && ch!='r'){
                    st.clear();
                    continue;
                }
                else if(ch=='r'){
                    st.add(ind);
                }
                else if(!st.isEmpty()){
                    cnt++;
                    vis[st.pop()] = true;
                    vis[ind] = true;
                }
            }
            
            ans += (Y*cnt);
        }
        else{
            for(int ind=0; ind<n; ind++){
                ch = S.charAt(ind);
                
                if(ch!='p' && ch!='r'){
                    st.clear();
                    continue;
                }
                else if(ch=='r'){
                    st.add(ind);
                }
                else if(!st.isEmpty()){
                    cnt++;
                    vis[st.pop()] = true;
                    vis[ind] = true;
                }
            }
            st.clear();
            
            ans += (Y*cnt);
            cnt=0;
            
            for(int ind=0; ind<n; ind++){
                if(!vis[ind]){
                    sb.append(S.charAt(ind));
                }
            }
            
            
            for(int ind=0; ind<sb.length(); ind++){
                ch = sb.charAt(ind);
                
                if(ch!='p' && ch!='r'){
                    st.clear();
                    continue;
                }
                else if(ch=='p'){
                    st.add(ind);
                }
                else if(!st.isEmpty()){
                    cnt++;
                    vis[st.pop()] = true;
                    vis[ind] = true;
                }
            }
            
            ans += (X*cnt);
        }
        
        return ans;
	}
} 
