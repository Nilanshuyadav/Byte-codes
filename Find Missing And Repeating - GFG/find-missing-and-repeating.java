//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int A[], int n) {
        int xor = 0;
        
        for(int ind=0; ind<n; ind++){
            xor ^= A[ind];
            xor ^= (ind+1);
        }
        
        int temp = 1, mask = 0;
        
        while(true){
            if((xor&temp)>0){
                mask = xor&temp;
                break;
            }    
            temp = temp<<1;    
        }
        
        int same=0, not_same=0;
        for(int ind=0; ind<n; ind++){
            if((mask&A[ind])>0)
                same ^= A[ind];
            else
                not_same ^= A[ind];
                
            if((mask&(ind+1))>0)
                same ^= (ind+1);
            else
                not_same ^= (ind+1);            
        }
        
        
        for(int ind=0; ind<n; ind++){
            if(A[ind]==same){
                return new int[]{same, not_same};
            }
            if(A[ind]==not_same)
                return new int[]{not_same, same};
        }
        
        return new int[]{0,0};
    }
}