class Solution {
    public int countEven(int num) {
        int cnt =0 ;
        for(int ind = 1; ind<=num; ind++){
            if(isEven(ind)) cnt++;
        }
        return cnt;
    }
    
    public boolean isEven(int n){
        StringBuilder sb = new StringBuilder(Integer.toString(n));
        int sum = 0;
        
        for(int ind=0; ind<sb.length(); ind++){
            sum += sb.charAt(ind)-'0';
        }
        
        return sum%2==0;
    }
}