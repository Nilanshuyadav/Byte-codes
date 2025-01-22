class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length, col = isWater[0].length;

        Queue<int[]> q  = new LinkedList<>();

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(isWater[r][c] == 1){
                    q.add(new int[]{r,c});
                    isWater[r][c] = 0;
                }else{
                    isWater[r][c] = -1;
                }
            }
        }

        int temp[], ro, co, new_r, new_c;
        int[] r_arr = {-1, 0, 1, 0}, c_arr = {0, 1, 0, -1};

        while(!q.isEmpty()){
            temp = q.remove();

            ro = temp[0];
            co = temp[1];

            for(int i=0; i<4; i++){
                new_r = ro + r_arr[i];
                new_c = co + c_arr[i];

                if(new_r<0 || new_c<0 || new_r>=row || new_c>=col || isWater[new_r][new_c]!=-1) continue;

                isWater[new_r][new_c] = isWater[ro][co] + 1;
                q.add(new int[]{new_r, new_c});
            }
        }

        return isWater;
    }
}