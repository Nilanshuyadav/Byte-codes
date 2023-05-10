class Solution {
    public int[][] generateMatrix(int n) {
        int k=1;
        int[][] arr = new int[n][n];
        int r1=0, r2=n-1, c1=0, c2=n-1, ind;
        
        while(r1<=r2 && c1<=c2){
            ind = c1;
            while(ind<=c2){
                arr[r1][ind++] = k++;
            }
            
            ind=r1+1;
            while(ind<=r2){
                arr[ind++][c2] = k++;
            }
            
            ind=c2-1;
            while(c1<ind){
                arr[r2][ind--] = k++;
            }
            
            ind=r2;
            while(r1<ind){
                arr[ind--][c1] = k++;
            }
            
            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        return arr;
    }
}