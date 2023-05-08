//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        List<long[]> al = new ArrayList<>();
        long pos;
        
        for(int ind=0; ind<N; ind++){
            pos = findPos(B, X-A[ind]);
            
            if(pos!=-1){
                al.add(new long[]{A[ind], X-A[ind]});
            }
        }
        
        pair[] ans = new pair[al.size()];
        
        for(int ind=0; ind<al.size(); ind++){
            ans[ind] = new pair(al.get(ind)[0], al.get(ind)[1]);
        }
        
        return ans;
    }
    
    public long findPos(long[] arr, long target){
        long l=0, h=arr.length-1;
        long m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(arr[(int)m] == target)    return m;
            else if(arr[(int)m] < target)    l = m+1;
            else    h=m-1;
        }
        
        return (long)-1;
    }
}