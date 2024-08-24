class Solution {
    public String nearestPalindromic(String st) {
        long n = Long.parseLong(st);
        
        long high = high(String.valueOf(n+1)),
                low = low(String.valueOf(n-1));
        
        return Math.abs(high-n) < Math.abs(low-n) ? String.valueOf(high) : String.valueOf(low);
    }
    
    public long low(String num){
        int n = num.length(), l;
        char[] nums = num.toCharArray(),
                t = Arrays.copyOf(nums, n);
        
        for(int i=0; i<n/2; i++){
            t[n-i-1] = t[i];
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] > t[i]) break;
            else if(nums[i] < t[i]){
                l = (n-1)/2;
                
                while(l>=0){
                    if(--t[l] < '0'){
                        t[l--] = '9';
                    }
                    else{
                        break;
                    }
                }
                
                if(t[0] == '0'){
                    char[] a = new char[n-1];
                    Arrays.fill(a, '9');
                    
                    return Long.parseLong(String.valueOf(a));
                }
                
                for(int j=0; j<n/2; j++){
                    t[n-j-1] = t[j];
                }
                
                break;
            }
        }
        
        return Long.parseLong(String.valueOf(t));
    }
    
    public long high(String num){
        int n = num.length(), l;
        char[] nums = num.toCharArray(), 
                t = Arrays.copyOf(nums, n);
        
        for(int i=0; i<n/2; i++){
            t[n-i-1] = t[i];
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] < t[i]){
                break;
            }
            else if(nums[i] > t[i]){
                l = (n-1)/2;
                
                while(l>=0){
                    if(++t[l] > '9'){
                        t[l--] = '0';
                    }
                    else{
                        break;
                    }
                }
                
                for(int j=0; j<n/2; j++){
                    t[n-j-1] = t[j];
                }
                
                break;
            }
            
        }
            
        return Long.parseLong(String.valueOf(t));
    }
}