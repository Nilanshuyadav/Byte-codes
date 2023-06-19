class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length(), i,j;
        int max = -1;
        
        for(int ind=1; ind<n; ind++){
            if(s.charAt(ind)==s.charAt(ind-1)){
                i = ind-1;
                j = ind;
                
                while(0<i){
                    if(s.charAt(i-1) != s.charAt(i)){
                        i--;
                    }
                    else{
                        break;
                    }
                }
                
                while(j<n-1){
                    if(s.charAt(j) != s.charAt(j+1)){
                        j++;
                    }
                    else{
                        break;
                    }
                }
                
                max = Math.max(max, j-i+1);
            }
        }
        
        return max==-1 ? n : max;
    }
}