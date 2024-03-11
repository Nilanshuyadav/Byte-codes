class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length, col=mat[0].length;
        
        int l=0, h=row-1, m, c;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            c = findMax(mat[m], col);
            
            if(!(m==0 || (mat[m-1][c]<mat[m][c]))) h=m-1;
            else if(!(m==row-1 || (mat[m+1][c]<mat[m][c]))) l=m+1;
            else return new int[]{m, c};
        }
        
        return new int[]{-1, -1};
    }
    
    public int findMax(int[] arr, int n){
        int max=0;
        
        for(int ind=0; ind<n; ind++){
            if(arr[ind] > arr[max]){
                max = ind;
            }
        }
        
        return max;
    }
}