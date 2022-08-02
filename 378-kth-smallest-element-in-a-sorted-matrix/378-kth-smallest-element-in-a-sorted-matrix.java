class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int[] arr = new int[row * col];
        
        int c = 0;
        
        for (int i =0;i<row;i++)
            for(int j : matrix[i]){
                arr[c++] = j; 
            }
        
        Arrays.sort(arr);
        
        return arr[k-1];
    }
}