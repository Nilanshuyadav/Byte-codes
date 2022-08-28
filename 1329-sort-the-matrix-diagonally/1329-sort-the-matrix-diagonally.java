class Solution {
    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int row = mat.length, col = mat[0].length;
        int r,c;
        
        for(int i = 0 ;i<col;i++){
            r = 0;
            c = i;
            while(r<row && c<col){
                pq.add(mat[r][c]);
                r++;
                c++;
            }
            r=0;
            c=i;
            while(r<row && c<col){
                mat[r][c] = pq.poll();
                r++;
                c++;
            }
        }
        
        for(int i = 1;i<row;i++){
            r = i;
            c = 0;
            while(r<row && c<col){
                pq.add(mat[r][c]);
                r++;
                c++;
            }
            r=i;
            c=0;
            while(r<row && c<col){
                mat[r][c] = pq.poll();
                r++;
                c++;
            }
        }
        return mat;
    }
}