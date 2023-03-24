//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here/
        int n = nums.length;
        boolean[] vis = new boolean[n];
        
        Pair[] arr = new Pair[n];
        
        for(int ind=0; ind<n; ind++){
            arr[ind] = new Pair(nums[ind], ind);
        }
        
        Arrays.sort(arr, (a, b) -> a.number - b.number);
        
        int cnt=0;
        
        for(int ind=0; ind<n; ind++){
            if(!vis[ind]){
                cnt += solve(ind, arr, vis)-1;
            }
        }
        
        return cnt;
    }
    
    public int solve(int ind, Pair[] arr, boolean[] vis){
        if(vis[ind])    return 0;
        
        vis[ind] = true;
        
        return solve(arr[ind].index, arr, vis)+1;
    }
}

class Pair{
    int number;
    int index;
    
    public Pair(int number, int index){
        this.number = number;
        this.index = index;
    }
}