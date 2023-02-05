class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int curr = n, digit, sum;
        
        while(!set.contains(curr)){
            sum = 0;
            set.add(curr);
            
            while(curr>0){
                digit = curr%10;
                curr = curr/10;
                
                sum += (digit*digit);
            }
            
            curr = sum;
            
            if(curr==1)
                return true;
        }
        
        return false;
    }
}