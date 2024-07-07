class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles, div=numBottles, rem;
        
        while(numBottles>=numExchange){
            div = numBottles/numExchange;
            rem = numBottles%numExchange;
            
            sum += div;
            numBottles = div+rem;
        }
        
        return sum;
    }
}