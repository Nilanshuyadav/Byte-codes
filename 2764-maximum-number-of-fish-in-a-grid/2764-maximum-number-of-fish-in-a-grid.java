class Solution {
    int[] r_arr = {-1,0,1,0}, c_arr={0,1,0,-1};
    boolean[][] vis;

    public int findMaxFish(int[][] grid) {
        int max = 0, totalFish=0;
        int row = grid.length, col = grid[0].length;
        vis = new boolean[row][col];

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] != 0 && !vis[r][c]){
                    totalFish = helper(r, c, grid, row, col);

                    max = Math.max(totalFish, max);
                }
            }
        }

        return max;
    }

    public int helper(int r, int c, int[][] grid, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        vis[r][c] = true;

        q.add(new int[]{r, c});
        int temp[], ro, co, sum=0, new_r, new_c;
        System.out.println();
        while(!q.isEmpty()){
            temp = q.remove();

            ro = temp[0];
            co = temp[1];

            sum += grid[ro][co];

            for(int i=0; i<4; i++){
                new_r = ro + r_arr[i];
                new_c = co + c_arr[i];

                if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || vis[new_r][new_c] || grid[new_r][new_c]==0) continue;

                vis[new_r][new_c] = true;
                q.add(new int[]{new_r,new_c});
            }

        }

        return sum;
    }
}