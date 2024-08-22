class Solution {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
        
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '0'){
                sb.setCharAt(i, '1');
            }
            else{
                sb.setCharAt(i, '0');
            }
        }
        
        int ans = Integer.parseInt(sb.toString(), 2);
        return ans;
    }
}