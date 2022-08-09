// class Solution {
//     public int nearestExit(char[][] maze, int[] entrance) {
//         int row = maze.length, col = maze[0].length;
        
//         Queue<Pair> q = new LinkedList<>();
        
//         q.add(new Pair(entrance[0],entrance[1]));
        
//         int[] r = {-1,1,0,0}, c = {0,0,-1,1};
        
//         int level = -1;
//         boolean flg = false;
        
//         while(!q.isEmpty()){
//             level++;
            
//             int size = q.size();
            
//             while(size-- > 0){
//                 Pair temp = q.remove();
                
                
//                 for(int i=0;i<4;i++){
//                     int tr = temp.row + r[i], tc = temp.col + c[i];
                    
//                     if((tr < 0 || tc < 0
//                       || tr == row || tc == col) 
//                       && level != 0 && flg == true )return level;
                    
//                     flg = true;
                    
//                     if(tr >= 0 && tc >= 0
//                       && tr < row && tc < col && maze[tr][tc] != '+')
//                     {
//                         maze[temp.row][temp.col] = '+';
//                         q.add(new Pair(tr,tc));
//                     }    
//                 }
//             }
//         }
//         return -1;
//     }
// }

// class Pair{
//     int row;
//     int col;
    
//     public Pair(int row, int col){
//         this.row = row;
//         this.col = col;
//     }
// }

class Solution {
    int [][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    public class Pair{
        int x;
        int y;
        
        Pair(int x,int y ){
            this.x=x;
            this.y=y;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        
        ArrayDeque<Pair> q =new ArrayDeque<>();
        q.add(new Pair(entrance[0],entrance[1]));
        maze[entrance[0]][entrance[1]]='+';
        int level=0;
        //boolean flag=false;
        while(q.size()!=0){
            int t =q.size();
            
            while(t-->0){
                Pair rem=q.remove();
                
                int x =rem.x;
                int y =rem.y;
                
                if(level>0 && (x==0 || x==maze.length-1 || y==0 || y==maze[x].length-1)){
                    return level;
                }
                
                // flag=true;
                
                for(int i =0;i<dir.length;i++){
                    int X=x+dir[i][0];
                    int Y=y+dir[i][1];
                    
                    if(X>=0 && X<maze.length && Y>=0 && Y<maze[X].length && maze[X][Y]=='.'){
                        q.add(new Pair(X,Y));
                        maze[X][Y]='+';
                        // System.out.println(X+" "+Y);
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
}