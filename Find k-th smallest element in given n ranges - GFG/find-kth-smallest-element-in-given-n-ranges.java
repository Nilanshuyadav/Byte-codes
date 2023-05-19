//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        // code here
        
        Arrays.sort(range, (a,b) -> a[0]-b[0]);
        int max = -1, ind=0, curr, toFind, elements;
        
        ArrayList<Integer> al = new ArrayList<>();
        
        while(ind<q){
            max = range[0][0];
            curr = 0;
            toFind = queries[ind];
            
            while(curr<n){
                elements = range[curr][1] - max + 1;
                
                if(toFind<=elements){
                    al.add(max + toFind - 1);
                    break;
                }
                else{
                    toFind -= elements;
                }
                
                curr++;
                
                if(curr == n){
                    al.add(-1);
                }
                else{
                    if(range[curr-1][1] < range[curr][0]){
                        max = range[curr][0];
                    }
                    else{
                        max = range[curr-1][1]+1;
                    }
                }
            }
            
            ind++;
        }
        
        return al;
    }
}
        
