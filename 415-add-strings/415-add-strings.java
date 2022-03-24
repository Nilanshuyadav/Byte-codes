class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        
        int carry = 0;
        
        StringBuilder ans = new StringBuilder("");
        
        while(i>=0 || j>=0 || carry>0){
            int vali = i>=0?num1.charAt(i)-'0':0;
            int valj = j>=0?num2.charAt(j)-'0':0;
            
            int sum = vali + valj + carry;
            
            carry = sum/10;
            
            ans.append(sum%10);
            
            i--;
            j--;
        }
        
        return ans.reverse().toString();
    }
}