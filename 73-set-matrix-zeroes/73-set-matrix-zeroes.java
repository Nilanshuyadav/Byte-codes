class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean[] r = new boolean[row],c = new boolean[col];
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(matrix[i][j] == 0){
                    r[i] = true;
                    c[j] = true;
                }
        
        for(int i=0;i<row;i++)
            if(r[i])
                for(int j=0;j<col;j++) matrix[i][j] = 0;
        
        for(int i=0;i<col;i++)
            if(c[i])
                for(int j=0;j<row;j++) matrix[j][i] = 0;
    }
}