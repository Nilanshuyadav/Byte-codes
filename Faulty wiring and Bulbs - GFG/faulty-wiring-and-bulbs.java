//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public static int countFlips(int a[], int n)
    {
        int cnt=0;
        int pre = a[n-1];
        
        for(int ind=n-1; ind>=0; ind--){
            if(a[ind] != pre){
                cnt++;
                pre = a[ind];
            }    
        }
        
        return a[0]==0?cnt+1:cnt;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    int arr[] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int index = 0;index < sizeOfArray; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution ob = new Solution();
		    System.out.println(ob.countFlips(arr,sizeOfArray));
		}
	}
}


// } Driver Code Ends