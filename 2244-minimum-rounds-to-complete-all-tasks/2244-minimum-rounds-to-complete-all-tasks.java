class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        
        for(int ind : tasks){
            freq.put(ind, freq.getOrDefault(ind,0)+1);
            max = Math.max(max, freq.get(ind));
        }
        
        int sum = 0;
        int[] dp = new int[max+1];
        Arrays.fill(dp, -2);
        int temp = 0;
        
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            temp = solve(entry.getValue(), dp);
            if(temp == -1){
                return -1;
            }
            
            sum += temp;
        }
        
        return sum;
    }
    
    public int solve(int n, int[] dp){
        if(n<2)
            return n==0? 0:-1;
        
        if(dp[n] != -2)
            return dp[n];
        
        if(n%3==0)
            return dp[n] = n/3;
        
        int three = (int)1e8, two = (int)1e8, temp;
        
        if(n-3>=0){
            temp = solve(n-3, dp);
            
            if(temp!=-1)
                three = 1+temp;
        }
        if(n-2>=0){
            temp = solve(n-2, dp);
            
            if(temp!=-1)
                two = 1+temp;
        }
        
        int min = Math.min(three, two);
        
        return dp[n] = min==(int)1e8?-1:min;
    }
}