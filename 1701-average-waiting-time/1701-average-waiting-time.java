class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum = 0;
        int i=0, n = customers.length, currentTime = 0, postTime;
        
        while(i<n){
            if(currentTime < customers[i][0]){
                currentTime = customers[i][0];
            }
            
            postTime = currentTime+customers[i][1];
            sum += postTime - customers[i][0];
            
            currentTime = postTime;
            i++;
        }
        
        return sum/n;
    }
}