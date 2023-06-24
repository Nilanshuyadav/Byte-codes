class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row = mat.length, col = mat[0].length;
        
        Map<Integer, int[]> mat_map = new HashMap<>();
        int[] row_arr = new int[row], col_arr = new int[col];
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                mat_map.put(mat[r][c], new int[]{r,c});
            }
        }
        
        int temp, r, c;
        for(int ind=0; ind<arr.length; ind++){
            temp = arr[ind];
            
            r = mat_map.get(temp)[0];
            c = mat_map.get(temp)[1];
            
            row_arr[r]++;
            col_arr[c]++;
            
            if(row_arr[r] == col || col_arr[c] == row){
                return ind;
            }
        }
        
        return -1;
    }
}