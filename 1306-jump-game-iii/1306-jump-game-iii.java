class Solution {
    Boolean[] V;
    boolean[] vis;
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        V = new Boolean[n];
        vis = new boolean[n];
        return function(arr,start,n);
    }
    
    public boolean function(int[] arr, int start, int n){
        if(arr[start] == 0) return true;
        if(V[start] != null) return V[start];
        if(vis[start] == true) return false;
        vis[start] = true;
        
        boolean temp1 = false,temp2 = false;
        
        if(start+arr[start] < n) temp1 = function(arr,start+arr[start],n);
        
        if(start - arr[start] >= 0) temp2 = function(arr,start-arr[start],n);
        
        
        return V[start] = (temp1||temp2);
    }
}