//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Arrays.sort(arr);
		    Complete obj = new Complete();
		    int ans = obj.maximizeSum(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximizeSum (int arr[], int n) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        
        for(int ind : arr){
            map.put(ind, map.getOrDefault(ind,0)+1);
        }
        
        int ans =0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int temp = entry.getKey();
            ans += (temp * entry.getValue());
            
            if(map.containsKey(temp-1)){
                int a = map.get(temp-1);
                
                a = Math.max(0, a-entry.getValue());
                map.put(temp-1, a);
            }
        }
        
        return ans;
    }
}


