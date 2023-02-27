class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        
        int r1=0, r2=row-1, c1=0, c2=col-1;
        
        List<Integer> ans = new ArrayList<>();
        int ind, total=row*col;
        
        while(total>0){
            ind = c1;
            while(ind<=c2 && total>0){
                total--;
                ans.add(matrix[r1][ind++]);
            }
            
            ind = r1+1;
            while(ind<=r2 && total>0){
                total--;
                ans.add(matrix[ind++][c2]);
            }
            
            ind = c2-1;
            while(ind>=c1 && total>0){
                total--;
                ans.add(matrix[r2][ind--]);
            }
            
            ind = r2-1;
            while(ind>r1 && total>0){
                total--;
                ans.add(matrix[ind--][c1]);
            }
            
            c1++;
            r1++;
            c2--;
            r2--;
        }
        
        return ans;
    }
}