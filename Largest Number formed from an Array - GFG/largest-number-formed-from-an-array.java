//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(String[] arr) {
        PriorityQueue<String> pq = new PriorityQueue<>(new my_comparator());
        StringBuilder ans = new StringBuilder("");
        
        for(String st : arr)
            pq.add(st);
            
        while(!pq.isEmpty())
            ans.append(pq.remove());
            
        return ans.toString();    
    }
}

class my_comparator implements Comparator<String>{
    public int compare(String s1, String s2){
        String s1_greater = s1+s2, s2_greater = s2+s1;
        
        return 0-s1_greater.compareTo(s2_greater);
    }
}