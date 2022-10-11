//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        Map<Character, Integer> map = new HashMap<>();
        
        for(int ind=0; ind<n; ind++)
            map.put(x[ind], b[ind]);
            
        StringBuilder sb = new StringBuilder(w), ans= new StringBuilder("");
        int sum=0, temp, new_l=0, l=0, h=0, max=Integer.MIN_VALUE;
        char ch;
        
        int max_temp=Integer.MIN_VALUE;
        char ch_temp='a';
        
        for(int ind=0; ind<sb.length(); ind++){
            ch = sb.charAt(ind);
            temp = map.containsKey(ch)?map.get(ch):ch;
            
            if(temp>max_temp){
                max_temp = Math.max(max_temp,temp);
                ch_temp = ch;
            }    
        }
        
        for(int ind=0; ind<sb.length(); ind++){
            ch = sb.charAt(ind);
            temp = map.containsKey(ch)?map.get(ch):ch;
            
            if(sum + temp<0) {new_l=ind+1; sum=0;}
            else sum += temp;
            
            if(sum!=0 && sum>max){
                l=new_l;
                h=ind+1;
                max=sum;
            }
        }
        //System.out.println(max_temp + " " + max);
        if(max_temp>max) ans = new StringBuilder(ch_temp+"");
        else ans = new StringBuilder(sb.substring(l,h));
        
        return ans.toString();
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends