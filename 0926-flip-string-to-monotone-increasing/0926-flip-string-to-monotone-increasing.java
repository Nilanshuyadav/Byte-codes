class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length(), low=0, high=n-1, ans=0, temp=0;
        
        while(temp<n){
            if(s.charAt(temp)=='1'){
                low = temp;
                break;
            }
            
            temp++;
        }
        
        if(temp==n){
            return 0;
        }
        
        temp=n-1;
        
        while(temp>=0){
            if(s.charAt(temp) == '0'){
                high = temp;
                break;
            }
            
            temp--;
        }
        
        if(temp == -1){
            return 0;
        }
        
        if(low>=high){
            return 0;
        }
        
        return solve(s, low, high);
    }
    
    public int solve(String s, int low, int high){
        int n = high-low+1;
        
        int[] zero = new int[n], one = new int[n];
        int zero_=0, one_=0;
        for(int ind=low, inx=high; ind<=high; ind++, inx--){
            if(s.charAt(ind) == '1'){
                zero[ind-low] = ++zero_;
            }
            else{
                zero[ind-low] = zero_;
            }
            
            if(s.charAt(inx) == '0'){
                one[high-ind] = ++one_;
            }
            else{
                one[high-ind] = one_;
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int ind=low; ind<=high; ind++){
            if(ind==low){
                min = Math.min(min, one[ind-low+1]);
            }
            else if(ind == high){
                min = Math.min(min, zero[ind-low-1]);
            }
            else{
                min = Math.min(min, one[ind-low+1]+zero[ind-low-1]);
            }
        }
        
        return min;
    }
}