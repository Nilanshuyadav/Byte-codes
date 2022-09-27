class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int from =0 ;
        StringBuilder sb = new StringBuilder(dominoes);
        
        for(int ind=0; ind<n; ind++){
            if(sb.charAt(ind)=='L')
                while(from<=ind)
                    sb.setCharAt(from++,'L');
            else if(sb.charAt(ind)=='R'){
                from=ind;
                int ind2;
                for(ind2=ind; ind2<n; ind2++){
                    if(sb.charAt(ind2)=='L') break;
                    if(sb.charAt(ind2)=='R'){
                        while(from<ind2) sb.setCharAt(from++,'R');
                    }
                }
                
                if(ind2==n)
                    while(from<n)
                        sb.setCharAt(from++,'R');
                else{
                    int len = ind2-from-1;
                    
                    for(int ind3=1; ind3<=len/2; ind3++){
                        sb.setCharAt(from+ind3,'R');
                        sb.setCharAt(ind2-ind3,'L');
                    }
                }
                
                ind = ind2;
                from = ind2+1;
            }
        }
        
        return sb.toString();
    }
}