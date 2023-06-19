class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int fuel = mainTank;
        int total=0;
        
        while(fuel>=5){
            fuel -= 5;
            
            total += 5;
            
            if(additionalTank>=1){
                fuel++;
                additionalTank--;
            }
        }
        
        total += fuel%5;
        
        return total*10;
    }
}