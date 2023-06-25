class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        return solve(0, n, 0, rods, new HashMap<>());
    }
    
    public int solve(int ind, int n, int diff, int[] rods, Map<String, Integer> dp){
        if(ind == n){
            return diff==0 ? 0 : -(int)1e8;
        }
        
        String st = ""+ind+","+diff;
        if(dp.containsKey(st)){
            return dp.get(st);
        }
        
        int bucket1 = rods[ind] + solve(ind+1, n, diff-rods[ind], rods, dp);
        int bucket2 = solve(ind+1, n, diff+rods[ind], rods, dp);
        int bucket3 = solve(ind+1, n, diff, rods, dp);
        
        dp.put(st, Math.max(bucket1, Math.max(bucket2, bucket3)));
        return dp.get(st);
    }
}