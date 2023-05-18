class Solution {
    int total;
    
    public int maxScore(int[] nums) {
        int n = nums.length;
        
        for(int ind=0; ind<n; ind++){
            total |= (1<<ind);
        }
        
        return solve(1, nums, 0, new HashMap<>());
    }
    
    public int solve(int index, int[] nums, int mask, Map<Integer, Integer> map){
        if(mask == total){
            return 0;
        }
        
        if(map.containsKey(mask)){
            return map.get(mask);
        }
        
        int max = 0, n=nums.length;
        
        for(int i=0; i<n-1; i++){
            if((mask&(1<<i)) != 0)  continue;
            
            for(int j=i+1; j<n; j++){
                if((mask&(1<<j)) != 0)  continue;
                
                max = Math.max(max, (index * (gcd(nums[i], nums[j]))) + solve(index+1, nums, mask | (1<<i) | (1<<j), map));
            }
        }
        
        map.put(mask, max);
        return map.get(mask);
    }
    
    public int gcd(int a, int b){
        if(b == 0)
            return a;
        
        return gcd(b, a%b);
    }
}