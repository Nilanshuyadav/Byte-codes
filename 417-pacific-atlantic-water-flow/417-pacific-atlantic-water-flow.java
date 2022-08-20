class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        int row = height.length,col = height[0].length;
        int[][] arr = new int[row][col];
        for(int i[] : arr)
            Arrays.fill(i,-1);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int[] r = {-1,0,1,0}, c={0,1,0,-1};
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<row;i++){
            q.add(new Pair(i,0));            
            arr[i][0] = 1;
        }
        
        for(int i=0;i<col;i++){
             q.add(new Pair(0,i));
             arr[0][i] = 1;
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col || arr[new_row][new_col] != -1 || height[temp.row][temp.col]>height[new_row][new_col]) continue;
                
                arr[new_row][new_col] = 1;
                q.add(new Pair(new_row,new_col));
            }
        }

        for(int i=0;i<row;i++){
            if(arr[i][col-1] == 1){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(col-1);
                ans.add(temp);
            }
            q.add(new Pair(i,col-1));
            arr[i][col-1] = 2;
            
        }
        
        for(int i=0;i<col;i++){
            if(arr[row-1][i] == 1){
                List<Integer> al = new ArrayList<>();
                al.add(row-1);
                al.add(i);
                ans.add(al);
            }            
             q.add(new Pair(row-1,i));
             arr[row-1][i] =  2;
        }
        
        while(!q.isEmpty()){
            Pair temp = q.remove();
            
            for(int i=0;i<4;i++){
                int new_row = temp.row+r[i];
                int new_col = temp.col+c[i];
                
                if(new_row<0 || new_col<0 || new_row>=row || new_col>=col||arr[new_row][new_col]==2 || height[temp.row][temp.col]>height[new_row][new_col]) continue;
                
                 if(arr[new_row][new_col] == 1) ans.add(new ArrayList<>(){{add(new_row); add(new_col);}});
                
                
                arr[new_row][new_col] = 2;
                q.add(new Pair(new_row,new_col));
            }
        }
        
        return ans;
    }
}

class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}