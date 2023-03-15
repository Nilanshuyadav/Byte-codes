class Solution {
    int max = (int)1e8;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Map<String, Integer> dp = new HashMap<>();

        int temp = solve(n-1, coins, amount, dp);
        return temp>=max ? -1 : temp;
    }
    
    public int solve(int ind, int[] coins, int amount, Map<String, Integer> dp){
        if(ind==0){
            return amount%coins[0] == 0? amount/coins[0] : max;
        }
        
        String st = "" + ind + "," + amount;
        
        if(dp.containsKey(st))
            return dp.get(st);
        
        int pick = max, not_pick=max, min;
        
        if(amount>=coins[ind]){
            pick = 1 + solve(ind, coins, amount-coins[ind], dp);
        }
        
        not_pick = solve(ind-1, coins, amount, dp);

        
        min = Math.min(pick, not_pick);
        
        dp.put(st, Math.min(min, max));
        
        return min>=max ? max : min;
    }
}