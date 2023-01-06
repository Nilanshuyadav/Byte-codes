class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int cnt=0;
        
        Arrays.sort(costs);
        
        for(int ind : costs){
            if(ind<=coins){
                cnt++;
                coins -= ind;
            }
            else
                break;
        }
        
        return cnt;
    }
}