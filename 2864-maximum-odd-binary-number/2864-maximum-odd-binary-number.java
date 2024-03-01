class Solution {
    public String maximumOddBinaryNumber(String str) {
        int n = str.length(), k=0;
        StringBuilder s = new StringBuilder(str);
        
        for(int ind=0; ind<n; ind++){
            if(s.charAt(ind)=='1'){
                s.setCharAt(k++, '1');
            }
        }
        
        while(k<n){
            s.setCharAt(k, '0');
            
            k++;
        }
        
        s.append('1');
        
        return s.substring(1).toString();
    }
}