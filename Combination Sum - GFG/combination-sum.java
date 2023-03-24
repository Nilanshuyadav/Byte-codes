//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> ans;
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        ans = new ArrayList<>();
        
        Set<Integer> set = new HashSet();
        for(int ind : A)
            set.add(ind);
            
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int ind : set)
            arr.add(ind);
        
        Collections.sort(arr);
        
        solve(0, arr, B, new ArrayList<>());
        
        return ans;
    }
    
    static void solve(int ind, ArrayList<Integer> arr, int target, ArrayList<Integer> temp){
        if(ind==arr.size()-1){
            if(target%arr.get(ind) == 0){
                for(int inx=0; inx<target/arr.get(ind); inx++){
                    temp.add(arr.get(ind));
                }
                
                ans.add(new ArrayList<>(temp)); 
                
                for(int inx=0; inx<target/arr.get(ind); inx++){
                    temp.remove(temp.size()-1);
                }
            }
            
            return;
        }
        
        if(arr.get(ind) <= target){
            temp.add(arr.get(ind));
            solve(ind, arr, target-arr.get(ind), temp);
            temp.remove(temp.size()-1);
        }
        
        solve(ind+1, arr, target, temp);
    }
}
