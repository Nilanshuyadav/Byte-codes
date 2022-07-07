class Solution {
    public int[] plusOne(int[] digits) {
       int n = digits.length;
        int carry = 0;
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = n-1;i>=0;i--){
            if(i == n-1)digits[i]++;
            else digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
            
            al.add(0,digits[i]);
            
        }
        
        if(carry != 0) al.add(0,1);
        
        return al.stream().mapToInt(i -> i).toArray();
    }
}