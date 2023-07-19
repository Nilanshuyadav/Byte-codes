class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int x, y;
        boolean bool=false;
        
        for(int ind=2; ind<=n/2; ind++){
            x = ind;
            y = n-ind;
            
            if(bool && ((x&1)==0 || (y&1)==0))    {continue;}
            bool = true;
            
            if(isPrime(x) && isPrime(y)){
                ans.add(new ArrayList<>(Arrays.asList(x, y)));
            }
        }
        
        return ans;
    }
    
    public boolean isPrime(int x){
        for(int i=2; i<=(int)Math.sqrt(x); i++){
            if(x%i == 0){
                return false;
            }
        }
        
        return true;
    }
}