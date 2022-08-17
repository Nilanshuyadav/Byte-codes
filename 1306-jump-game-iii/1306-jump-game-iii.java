class Solution {
    
    boolean[] vis;
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        
        vis = new boolean[n];
        return function(arr,start,n);
    }
    
    public boolean function(int[] arr, int start, int n){
        if(arr[start] == 0) return true;
        
        if(vis[start] == true) return false;
        vis[start] = true;
        
        boolean temp1 = false,temp2 = false;
        
        if(start+arr[start] < n) temp1 = function(arr,start+arr[start],n);
        
        if(start - arr[start] >= 0) temp2 = function(arr,start-arr[start],n);
        
        
        return (temp1||temp2);
        
        /********************************************************************/
        
//         if(vis[start]) return false;
//         if(arr[start] == 0) return true;
//         vis[start] = true;
//         int prev = start-arr[start],next = start+arr[start];
        
//         boolean temp1 = false, temp2 = false;
        
//         if(prev >= 0) temp1 = function(arr,prev,n);
//         if(next < n) temp2 = function(arr,next,n);
        
//         return temp1||temp2;
    }
}