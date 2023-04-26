class Solution {
    public int addDigits(int num) {
        int total=0;
        
        while(num>0){
            total += num%10;
            num /= 10;
        }
        
        return total>9 ? addDigits(total) : total;
    }
}