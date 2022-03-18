class Solution {
    public String convert(String s, int numRows) {
        
        int n = s.length();
        if(n == 1|| numRows == 1) return s;
        
        int j,i;
        String ans = "";
        
        for(int k=0;k<numRows;k++){
            j = k;
            i = 0;
            if(k == 0 || k == numRows-1){
                while(j<n){
                    ans = ans + s.charAt(j);
                    j = j + ((2*numRows)-2);
                }
            }
            else{
                while(j<n){
                    if(i==0){
                        ans = ans + s.charAt(j);
                        j = j + ((2*(numRows-k))-2);
                        i=1;
                    }
                    else{
                        ans = ans + s.charAt(j);
                        j = j + ((2*(k+1))-2);
                        i=0;
                    }
                }
            }
        }
        return ans;
    }
}