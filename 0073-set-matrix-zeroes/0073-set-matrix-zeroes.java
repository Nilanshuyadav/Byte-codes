class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> r = new HashSet<>(), c = new HashSet<>();
        
        int row = matrix.length, col = matrix[0].length;
        
        for(int ro=0; ro<row; ro++){
            for(int co=0; co<col; co++){
                if(matrix[ro][co] == 0){
                    r.add(ro);
                    c.add(co);
                }
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(r.contains(i) || c.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}