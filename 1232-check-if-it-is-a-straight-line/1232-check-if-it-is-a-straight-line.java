class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        
        for(int ind=2; ind<coordinates.length; ind++){
            int x = coordinates[ind][0];
            int y = coordinates[ind][1];
            
            if((x-x0)*(y1-y0) != (y-y0)*(x1-x0)){
                return false;
            }
        }
        
        return true;
    }
}

// (x - x0) * (y1 - y0) != (y - y0) * (x1 - x0)