class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length, col=mat[0].length;
        
        int l=0, h=row-1, m, max;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            max = findMax(mat[m], col);
            
            if(m!=0 && mat[m-1][max]>mat[m][max]) h=m-1;
            else if(m!=row-1 && mat[m+1][max]>mat[m][max]) l=m+1;
            else return new int[]{m, max};
        }
        
        return new int[]{-1, -1};
    }
    
    public int findMax(int[] arr, int col){
        int max=0;
        
        for(int i=0; i<col; i++){
            if(arr[i]>arr[max]){
                max = i;
            }
        }
        
        return max;
    }
}