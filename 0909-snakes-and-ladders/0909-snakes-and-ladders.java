class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, end = n*n;
        
        for(int ind=0; ind<n; ind++){
            for(int inx=0; inx<n; inx++)
                System.out.print(board[ind][inx]+" ");
            System.out.println();
        }
        
        boolean[][] vis = new boolean[n][n];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.steps - b.steps);
        
        pq.add(new Pair(1, 0));
        
        Pair temp;
        int ind, steps, new_ind, index[] = new int[2];
        
        while(!pq.isEmpty()){
            temp = pq.remove();
            
            ind = temp.ind;
            steps = temp.steps;
            
            for(int i=1; i<=6; i++){
                new_ind = ind+i;
                
                if(new_ind>end)
                    break;
                
                index = findIndex(n, new_ind);
                
//                 System.out.println(new_ind+" "+index[0]+" "+index[1]);
                // if(vis[index[0]][index[1]])
                //     continue;
                
                if(board[index[0]][index[1]] != -1){
                    new_ind = board[index[0]][index[1]];
                    
                    index = findIndex(n, new_ind);
                }
                
                if(vis[index[0]][index[1]])
                    continue;
                
                if(new_ind==end){
                    return steps+1;
                }
                
                vis[index[0]][index[1]] = true;
                pq.add(new Pair(new_ind, steps+1));
            }
        }
        
        return -1;
    }
    
    public int[] findIndex(int n, int temp){
        int temp_row = temp%n==0? n - (temp/n) : n - (temp/n)-1;
        int temp_col;

        if(n%2==0){
            if(temp_row%2==0){
                temp_col = n - (temp - ((n-temp_row-1)*n));
            }
            else{
                temp_col = (temp - ((n-temp_row-1)*n))-1;
            }
        }
        else{
            if(temp_row%2==0){
                temp_col = (temp - ((n-temp_row-1)*n))-1;
            }
            else{
                temp_col = n - (temp - ((n-temp_row-1)*n));
            }
        }
        
        return new int[]{temp_row, temp_col};
    }
    
}

class Pair{
    int ind;
    int steps;
    
    public Pair(int ind, int steps){
        this.ind = ind;
        this.steps = steps;
    }
}