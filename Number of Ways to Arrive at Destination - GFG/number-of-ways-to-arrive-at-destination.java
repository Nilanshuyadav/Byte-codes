//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int ind=0; ind<n; ind++)
            adj.add(new ArrayList<>());
        
        for(List<Integer> al : roads){
            adj.get(al.get(0)).add(new int[]{al.get(1), al.get(2)});
            adj.get(al.get(1)).add(new int[]{al.get(0), al.get(2)});
        }
        
        Queue<Pair> q = new LinkedList<>();
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        
        q.add(new Pair(0,0));
        int ans=0;
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int[] ind : adj.get(temp.ind)){
                if(arr[ind[0]] == temp.time+ind[1] && ind[0]==n-1){
                    ans = (ans+1)%1000000007;
                }
                
                else if(arr[ind[0]] >= temp.time+ind[1]){
                    arr[ind[0]] = temp.time+ind[1];
                    
                    if(ind[0]==n-1){
                        ans=1;
                    }
                    else
                        q.add(new Pair(ind[0], temp.time+ind[1]));
                }
            }
        }
        
        return ans;
    }
}

class Pair{
    int ind;
    int time;
    public Pair(int ind, int time){
        this.ind = ind;
        this.time = time;
    }
}