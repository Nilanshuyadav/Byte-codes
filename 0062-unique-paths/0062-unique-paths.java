class Solution {
    public int uniquePaths(int m, int n) {
        int[] arr = new int[n];
        int pre=0;
        
        arr[0] = 1;
        pre=1;
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(r==0 && c==0)    continue;
                
                arr[c] = arr[c]+pre;
                pre = arr[c];
            }
            
            pre=0;
        }
        
        return arr[n-1];
    }
}