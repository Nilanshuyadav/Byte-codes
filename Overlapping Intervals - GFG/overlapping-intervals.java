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
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        
        Arrays.sort(Intervals, (a,b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        
        int start=Intervals[0][0], end = Intervals[0][1];
        
        List<int[]> al = new ArrayList<>();
        
        for(int ind[] : Intervals){
            if(end<ind[0]){
                al.add(new int[]{start, end});
                start = ind[0];
                end = ind[1];
            }
            
            end = Math.max(end, ind[1]);
        }
        
        al.add(new int[]{start, end});
        
        int[][] arr = new int[al.size()][2];
        int k=0;
        
        for(int ind[] : al){
            arr[k][0] = ind[0];
            arr[k][1] = ind[1];
            k++;
        }
        
        return arr;
    }
}