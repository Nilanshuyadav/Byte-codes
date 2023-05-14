class Solution {
    int total;
    public int maxScore(int[] nums) {
        int n = nums.length;
        
        for(int ind=0; ind<n; ind++){
            total |= (1<<ind);
        }
        
        return solve(1, nums, n, 0, new HashMap());
    }
    
    public int solve(int op, int[] nums, int n, int mask, Map<Integer, Integer> map){
        if(mask == total){
            return 0;
        }
        
        if(map.containsKey(mask)){
            return map.get(mask);
        }
        
        int max=0;
        
        for(int i=0; i<n; i++){
            if((mask&(1<<i)) != 0) continue;
            
            for(int j=0; j<n; j++){
                if((mask&(1<<j)) != 0 || i==j)  continue;
                    
                max = Math.max(solve(op+1, nums, n, mask|(1<<i)|(1<<j), map) + (gcd(nums[i], nums[j])*op), max);    
            }
        }
        
        map.put(mask, max);
        
        return max;
    }
    
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        
        return gcd(b, a%b);
    }
}