class Solution {
    public int reverse(int x) {
        long temp = 0;
        boolean negative = false;
        
        if(x<0)
            negative = true;
        
        x = Math.abs(x);
        
        while(0<x){
            int digit = x%10;
            
            temp = (temp*10)+digit;
            x = x/10;
        }
        
        if(negative)
            temp = 0-temp;
        
        return (Integer.MIN_VALUE<=temp && temp<=Integer.MAX_VALUE)?(int)temp:0;
    }
}