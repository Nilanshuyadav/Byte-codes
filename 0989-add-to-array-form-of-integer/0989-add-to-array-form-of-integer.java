class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length-1;
        
        int i, j, sum, carry=0;
        List<Integer> ans = new ArrayList<>();
        
        while(n>=0 || k>0){
            if(n<0)
                i=0;
            else
                i=num[n--];
            
            if(k==0)
                j=0;
            else{
                j=k%10;
                k=k/10;
            }
            
            sum = i+j+carry;
            
            ans.add(0, sum%10);
            carry = sum/10;
        }
        
        if(carry>0)
            ans.add(0, carry);
        
        return ans;
    }
}